package todo1.hulkstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo1.hulkstore.model.Product;
import todo1.hulkstore.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getOne(long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        Iterable<Product> products = productRepository.findAll();
        List<Product> productList = new ArrayList<Product>();
        products.forEach(productList::add);
        return  productList;
    }

    public Product createProduct(Product product){
       return productRepository.save(product);
    }

    public void deleteProductById(long productId){
        productRepository.deleteById(productId);
    }

    public void deleteAllProducts(){
        productRepository.deleteAll();
    }

}
