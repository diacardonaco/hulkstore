package todo1.hulkstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import todo1.hulkstore.model.Product;
import todo1.hulkstore.repository.ProductRepository;
import todo1.hulkstore.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class HulkstoreApplicationTests {

	@MockBean
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@Test
	public void getAllProductTest() {
		when(productRepository.findAll()).thenReturn(new ArrayList<>());
		assert(productService.getAllProducts()).isEmpty();
	}

	@Test
	public void getOneProductTest() {

		Product productExpected = new Product();
		productExpected.setDescription("tv");
		productExpected.setName("tv");
		productExpected.setPrice(1000);
		productExpected.setAmount(100);

		when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productExpected));
		Optional<Product> productedObtained = productService.getOne(3);
		assertEquals(productExpected, Optional.of(productedObtained));
	}

}
