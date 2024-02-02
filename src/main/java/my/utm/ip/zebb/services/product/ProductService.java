package my.utm.ip.zebb.services.product;

import java.util.*;
import my.utm.ip.zebb.models.product.Product;

public interface ProductService{
    
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product addProduct(final Product product);
    Product updateProduct(final Product product);
    public boolean deleteProduct(String id);
}
