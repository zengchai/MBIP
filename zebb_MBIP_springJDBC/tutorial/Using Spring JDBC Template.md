# Using Spring JDBC Templ[Diagnostics.CodeAnalysis.SuppressMessageAttribute(

##Project File Structure

#Main Folders

src/main
src/main/java
src/main/java/{app_package}
src/main/java/configs
src/main/java/configs/AppConfig.java
src/main/java/configs/DatabaseConfig.java
src/main/java/controllers
src/main/java/controllers/MainController.java
src/main/java/controllers/ProductController.java
src/main/java/controllers/LoginController.java
src/main/java/models
src/main/java/models/product
src/main/java/models/product/Product.java
src/main/java/models/product/ProductDAO.java
src/main/java/models/product/ProductRepository.java
src/main/java/models/user/
src/main/java/models/user/User.java
src/main/java/models/user/UserDAO.java
src/main/java/models/user/UserRepository.java

src/main/webapp
src/main/webapp/WEB-INF
src/main/webapp/static
src/main/webapp/static/common
src/main/webapp/static/common/css
src/main/webapp/static/common/js
src/main/webapp/static/common/images
src/main/webapp/static/common/images/logo.jpg

src/main/webapp/static/home
src/main/webapp/static/home/css
src/main/webapp/static/home/js
src/main/webapp/static/home/images
src/main/webapp/static/product


src/main/webapp/views
src/main/webapp/views/common
src/main/webapp/views/common/header.jsp
src/main/webapp/views/common/footer.jsp
src/main/webapp/views/home
src/main/webapp/views/home/home.jsp
src/main/webapp/views/product
src/main/webapp/views/login



## DatabaseConfig.java 

@Configuration
public class DatabaseConfig {

    private DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
         return new JdbcTemplate(getDataSource());
    }
}

## TestController.java 