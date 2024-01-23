package my.utm.ip.zebb.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import my.utm.ip.zebb.models.product.ProductRepository;
import my.utm.ip.zebb.models.product.ProductRepository_JDBC;
import my.utm.ip.zebb.models.recycleData.RecyclingRepository;
import my.utm.ip.zebb.models.recycleData.RecyclingRepository_JDBC;
import my.utm.ip.zebb.services.product.ProductService;
import my.utm.ip.zebb.services.product.ProductService_Database;
import my.utm.ip.zebb.services.recycleData.RecyclingService;
import my.utm.ip.zebb.services.recycleData.RecyclingService_Database;
import my.utm.ip.zebb.services.winner.WinnerService;
import my.utm.ip.zebb.models.winner.WinnerRepository;
import my.utm.ip.zebb.models.winner.WinnerRepository_JDBC;
import my.utm.ip.zebb.services.winner.WinnerService_Database;

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










    

    //========================================================
    @Bean
    WinnerService winnerService() {
        return new WinnerService_Database();
    }

    // Repositories
    @Bean
    WinnerRepository winnerRepository() {
        return new WinnerRepository_JDBC();
    }

    //========================================================
    @Bean
    RecyclingService recyclingService() {
        return new RecyclingService_Database();
    }

    // Repositories
    @Bean
    RecyclingRepository recyclingRepository() {
        return new RecyclingRepository_JDBC();
    }
}
