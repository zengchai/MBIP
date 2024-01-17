package my.utm.ip.springmvcmaven.services.product;

import java.util.*;

import my.utm.ip.springmvcmaven.models.product.Product;

public class ProductService_Memory implements ProductService {

    // simulate a product table with internal memory

    final private List<Product> products = new ArrayList<Product>();

    // helper method for the CRUD operations
    private Product insertProduct(final Product product) {
        Product copy = product.copy();
        // id is internally generated (auto generation)
        int id;
        
        if (products.size()==0){
            id = 1;
        }
        else{
            String lastId = products.get(products.size()-1).getId();
            id = Integer.parseInt(lastId) + 1;
        }
        
        copy.setId(id + "");
        products.add(copy);

        return product;
    }

    private Product insertProduct(String category, String name, String description, double price) {
        // id is internally generated.

        return insertProduct(new Product("", category, name, description, price));

    }

    public ProductService_Memory() {

        // Create memory data to simulate the Product table 
        insertProduct("Electronics", "Laptop", "8GB RAM, 512GB SSD", 999);
        insertProduct("Electronics", "Computer", "SSD Storage 1TB", 399);
        insertProduct("Electronics", "Smartphone", "5.5-inch display, 128GB storage", 599);
        insertProduct("Appliances", "Coffee Maker", "Automatic drip, 12-cup capacity", 49.99);
        insertProduct("Electronics", "Headphones", "Over-ear, noise-canceling", 129.99);
        insertProduct("Wearables", "Fitness Tracker", "Heart rate monitor, step counter", 79.99);
        insertProduct("Home", "Smart Thermostat", "Programmable, energy-efficient", 129.99);
        insertProduct("Appliances", "Blender", "High-performance blender, 1000W", 79.99);
        insertProduct("Wearables", "Smartwatch", "Fitness tracking, notifications", 199.99);
        insertProduct("Home", "Robot Vacuum", "Smart cleaning, automatic charging", 299.99);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> copyList = new ArrayList<Product>();
        copyList.addAll(products);
        return copyList;
    }

    @Override
    public Product getProductById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    @Override
    public Product addProduct(final Product product) {
        Product found = getProductById(product.getId());

        // If the product does not already exist, insert it
        if (found == null) {

            return insertProduct(product);

        }

        // Return null if the ID is empty or the product already exists
        return null;
    }

    @Override
    public Product updateProduct(final Product product) {
        // Check if the record already exists, If it doesnt cancel the operation
        Product found = getProductById(product.getId());
        if (found == null)
            return null;

        found.assign(product);

        return found;
    }


    @Override
    public boolean deleteProduct(String id){

        // deletion is only successfull if the required data exists
        Product found = getProductById(id);
        if (found==null) return false;

        products.remove(found);

        return true;

    }

}
