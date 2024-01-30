package my.utm.ip.zebb.configs;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    private DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("aeiou12345");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    // Loy's database
    // private DriverManagerDataSource getDataSource(){
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
    // dataSource.setUsername("root");
    // dataSource.setPassword("aeiou12345");
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
    // dataSource.setUsername("root");
    // dataSource.setPassword("aeiou12345");

    // return dataSource;
    // return dataSource;
    // }

    // @Bean
    // JdbcTemplate jdbcTemplate(){
    // return new JdbcTemplate(getDataSource());
    // return new JdbcTemplate(getDataSource());
    // }

    // yam's database

    // yam's database
    // private DriverManagerDataSource getDataSource(){
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:3306/zebb_yam");
    // dataSource.setUsername("root");
    // dataSource.setPassword("admin");
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:3306/zebb_yam");
    // dataSource.setUsername("root");
    // dataSource.setPassword("admin");

    // return dataSource;
    // return dataSource;
    // }

    // @Bean
    // JdbcTemplate jdbcTemplate(){
    // return new JdbcTemplate(getDataSource());
    // return new JdbcTemplate(getDataSource());
    // }


}
