package my.utm.ip.zebb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.utm.ip.zebb.models.product.Product;
import my.utm.ip.zebb.models.product.ProductDAO;
import my.utm.ip.zebb.models.product.ProductRepository;
import my.utm.ip.zebb.services.product.ProductService;

@Controller
@RequestMapping("/test")
public class TestController {

    

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductRepository repo;

    @Autowired
    private ProductService service;


    @ResponseBody
    @RequestMapping("/jdbc")
    public String jdbcTest(){

        String sql = "SELECT * FROM products";
        final List<ProductDAO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDAO>(ProductDAO.class));
        return list.toString();
    }

    @ResponseBody
    @RequestMapping("/repo")
    public String repoTest(){

        final List<ProductDAO> list = repo.getAllProducts();
        return list.toString();
    }

    @ResponseBody
    @RequestMapping("/service")
    public String repoService(){

        // final Product product = service.getProductById("9");
        // return product.toString();
        
        // final List<Product> list = service.getAllProducts();
        // return list.toString();

        // boolean deleteResult = service.deleteProduct("2");
        // return deleteResult +"";


        final Product product= new Product("8", "Kitchen", "Toaster", "Compact toaster oven with multiple cooking functions.",9);
        final Product update = service.updateProduct(product);
        return update.toString();
            
        
    }

}

