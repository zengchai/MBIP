package my.utm.ip.springmvcmaven.services.product;

import java.util.*;
import my.utm.ip.springmvcmaven.models.product.Product;

public interface ProductService{
    
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product addProduct(final Product product);
    Product updateProduct(final Product product);
    public boolean deleteProduct(String id);
}


