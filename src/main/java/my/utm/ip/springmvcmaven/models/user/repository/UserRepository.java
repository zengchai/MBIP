package my.utm.ip.springmvcmaven.models.user.repository;

import org.springframework.stereotype.Repository;

import my.utm.ip.springmvcmaven.models.user.UserDAO;

@Repository
public interface UserRepository {

    UserDAO register(final UserDAO product);
    UserDAO login(String id);
    UserDAO updateProfile(final UserDAO user);
    
}
