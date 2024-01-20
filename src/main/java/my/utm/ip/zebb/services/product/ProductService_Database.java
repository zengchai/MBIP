package my.utm.ip.zebb.services.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.product.Product;
import my.utm.ip.zebb.models.product.ProductDAO;
import my.utm.ip.zebb.models.product.ProductRepository;

public class ProductService_Database implements ProductService {
    
    @Autowired
    ProductRepository repo;

    @Override
    public Product addProduct(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteProduct(String id) {
        boolean success=repo.deleteProduct(id);
        return success;

    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductDAO> daos = repo.getAllProducts();
        List<Product> products = new ArrayList<Product>();
        for (ProductDAO dao:daos){
             products.add(new Product(dao) );
        }
        return products;
    }

    @Override
    public Product getProductById(String id) {
        ProductDAO dao =repo.getProductById(id);
        Product product= new Product();
        product.fromDAO(dao);

        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        ProductDAO dao = repo.updateProduct(product.toDAO());
        return new Product(dao);
    }
    
}
