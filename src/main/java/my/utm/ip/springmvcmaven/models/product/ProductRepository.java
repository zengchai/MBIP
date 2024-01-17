package my.utm.ip.springmvcmaven.models.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
   
    List<ProductDAO> getAllProducts();
    ProductDAO addProduct(final ProductDAO product);
    ProductDAO getProductById(String id);
    ProductDAO updateProduct(final ProductDAO product);
    public boolean deleteProduct(String id);
}    



