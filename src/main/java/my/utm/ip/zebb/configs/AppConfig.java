package my.utm.ip.zebb.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import my.utm.ip.zebb.models.user.repository.UserRepository;
import my.utm.ip.zebb.models.user.repository.UserRepository_JDBC;
import my.utm.ip.zebb.models.waterData.WaterRepository;
import my.utm.ip.zebb.models.waterData.WaterRepository_JDBC;
import my.utm.ip.zebb.services.user.UserService_JDBC;
import my.utm.ip.zebb.services.waterData.WaterService;
import my.utm.ip.zebb.services.waterData.WaterService_Database;
import my.utm.ip.zebb.models.electricalData.ElectricalRepository;
import my.utm.ip.zebb.models.electricalData.ElectricalRepository_JDBC;

import my.utm.ip.zebb.models.recycleData.RecyclingRepository;
import my.utm.ip.zebb.models.recycleData.RecyclingRepository_JDBC;
import my.utm.ip.zebb.services.electricalData.ElectricalService;
import my.utm.ip.zebb.services.electricalData.ElectricalService_Database;

import my.utm.ip.zebb.services.user.UserService;
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
    UserService userService() {
        return new UserService_JDBC();
    }

    @Bean
    UserRepository userRepository() {
        return new UserRepository_JDBC();

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

    @Bean
    WaterService waterService() {
        return new WaterService_Database();
    }

    // Repositories
    @Bean
    WaterRepository waterRepository() {
        return new WaterRepository_JDBC();
    }
    
    @Bean
    ElectricalService electricalService() {
        return new ElectricalService_Database();
    }

    // Repositories
    @Bean
    ElectricalRepository electricalRepository() {
        return new ElectricalRepository_JDBC();
    }
}
