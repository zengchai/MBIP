package my.utm.ip.zebb.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import my.utm.ip.zebb.models.user.repository.UserRepository;
import my.utm.ip.zebb.models.user.repository.UserRepository_JDBC;
import my.utm.ip.zebb.models.waterData.Repository.WaterRepository;
import my.utm.ip.zebb.models.waterData.Repository.WaterRepository_JDBC;
import my.utm.ip.zebb.models.winner.Repository.WinnerRepository;
import my.utm.ip.zebb.models.winner.Repository.WinnerRepository_JDBC;
import my.utm.ip.zebb.services.user.UserService_JDBC;
import my.utm.ip.zebb.services.waterData.WaterService;
import my.utm.ip.zebb.services.waterData.WaterService_Database;
import my.utm.ip.zebb.models.electricalData.Repository.ElectricalRepository;
import my.utm.ip.zebb.models.electricalData.Repository.ElectricalRepository_JDBC;
import my.utm.ip.zebb.models.recycleData.Repository.RecyclingRepository;
import my.utm.ip.zebb.models.recycleData.Repository.RecyclingRepository_JDBC;
import my.utm.ip.zebb.models.timeline.TimelineRepository;
import my.utm.ip.zebb.models.timeline.TimelineRepository_JDBC;
import my.utm.ip.zebb.services.electricalData.ElectricalService;
import my.utm.ip.zebb.services.electricalData.ElectricalService_Database;

import my.utm.ip.zebb.services.user.UserService;
import my.utm.ip.zebb.services.recycleData.RecyclingService;
import my.utm.ip.zebb.services.recycleData.RecyclingService_Database;
import my.utm.ip.zebb.services.timeline.TimelineService;
import my.utm.ip.zebb.services.timeline.TimelineService_JDBC;
import my.utm.ip.zebb.models.timeline.TimelineRepository;
import my.utm.ip.zebb.models.timeline.TimelineRepository_JDBC;
import my.utm.ip.zebb.services.winner.WinnerService;
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
    @Bean 
    TimelineService timelineService() {
        return new TimelineService_JDBC();
    }

    @Bean
    TimelineRepository timelineRepository() {
        return new TimelineRepository_JDBC();

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
