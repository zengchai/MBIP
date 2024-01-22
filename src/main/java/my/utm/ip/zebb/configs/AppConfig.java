package my.utm.ip.zebb.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import my.utm.ip.zebb.models.product.ProductRepository;
import my.utm.ip.zebb.models.product.ProductRepository_JDBC;
import my.utm.ip.zebb.services.product.ProductService;
import my.utm.ip.zebb.services.product.ProductService_Database;

@Configuration
public class AppConfig {

    // Load all services required by the app

    @Bean
    ProductService productService() {
        // return new ProductService_Memory();
        return new ProductService_Database();
    }

    // Repositories
    @Bean
    ProductRepository productRepository() {
        return new ProductRepository_JDBC();
    }
}
