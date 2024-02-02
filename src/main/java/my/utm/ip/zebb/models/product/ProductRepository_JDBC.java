package my.utm.ip.zebb.models.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductRepository_JDBC implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductDAO> getAllProducts() {

        String sql = "SELECT * FROM products";

        final List<ProductDAO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDAO>(ProductDAO.class));

        return list;
    } 

    @Override
    public ProductDAO addProduct(ProductDAO product) {
        ProductDAO added = null;

        String sql = "INSERT INTO products VALUES (?,?,?,?,?,?);";
        Object[] arg = { product.getProduct_name(),
                product.getCategory(),
                product.getDetails(),
                product.getPrice(),
                product.getStock_quantity(),
                product.getManufacturer()
        };

        jdbcTemplate.update(sql, arg);

        return added;
    }

    @Override
    public ProductDAO getProductById(String id) {
        String sql = "SELECT * FROM products WHERE product_id=?";
        ProductDAO product = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<ProductDAO>(ProductDAO.class),
                id);
        return product;
    }

    @Override
    public ProductDAO updateProduct(final ProductDAO product) {

        StringBuilder sql = new StringBuilder("UPDATE products SET ");
        
        if (product.getProduct_name()!= null){
            sql.append("product_name='").append(product.getProduct_name()).append("', ");
        }
        
        if (product.getCategory()!= null){
            sql.append("category='").append(product.getCategory()).append("', ");
        }
        
        if (product.getDetails()!= null){
            sql.append("details='").append(product.getDetails()).append("', ");
        }

        Double price = product.getPrice();
        if (price!= null){
            sql.append("price=").append(product.getPrice()).append(", ");
        }

        Integer qty = product.getStock_quantity();
        if (qty!= null){
            sql.append("stock_quantity=").append(product.getStock_quantity()).append(", ");;
        }

               
        if (product.getManufacturer()!= null){
            sql.append("manufacturer='").append(product.getManufacturer()).append("' ");

        sql.append("WHERE product_id=?");
        }

        
        int count = jdbcTemplate.update(sql.toString(), product.getProduct_id());

        if (count>0)
            return product;

        return null;

    }

    @Override
    public boolean deleteProduct(String id) {
        String sql = "DELETE FROM products WHERE product_id=?";
        int count = jdbcTemplate.update(sql, id);

        return count > 0;

    }

}
