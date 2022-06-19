package todo1.hulkstore.repository;

import org.springframework.data.repository.CrudRepository;
import todo1.hulkstore.model.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
