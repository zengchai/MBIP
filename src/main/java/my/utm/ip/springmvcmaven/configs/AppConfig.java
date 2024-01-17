package my.utm.ip.springmvcmaven.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import my.utm.ip.springmvcmaven.models.product.ProductRepository;
import my.utm.ip.springmvcmaven.models.product.ProductRepository_JDBC;
import my.utm.ip.springmvcmaven.services.product.ProductService;
import my.utm.ip.springmvcmaven.services.product.ProductService_Database;
import my.utm.ip.springmvcmaven.services.product.ProductService_Memory;

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
