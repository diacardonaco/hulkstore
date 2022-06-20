package todo1.hulkstore.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import todo1.hulkstore.HulkstoreApplication;
import todo1.hulkstore.model.Product;
import todo1.hulkstore.repository.ProductRepository;
import todo1.hulkstore.service.ProductService;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductTest extends HulkstoreApplication {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private List<Product> productList;
    private Product product1;
    private Product product2;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        productList = new ArrayList<Product>();

        product1 = new Product();
        product1.setDescription("tv");
        product1.setName("tv");
        product1.setPrice(1000);
        product1.setAmount(100);

        product2 = new Product();
        product2.setDescription("laptop");
        product2.setName("laptop");
        product2.setPrice(333388);
        product2.setAmount(45);

        productList.add(product1);
        productList.add(product2);
    }



    @MockBean
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    public void getAllProductTest() {
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> productListObtained = productService.getAllProducts();
        assertEquals(productList,productListObtained);
    }

    @Test
    public void getOneProductTest() {
        Product productExpected = product1;
        when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productExpected));
        Optional<Product> productResult = productService.getOne(3);
        assertEquals(productExpected.getDescription(), productResult.get().getDescription());
    }


}
