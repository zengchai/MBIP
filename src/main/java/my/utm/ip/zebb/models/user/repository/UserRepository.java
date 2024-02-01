package my.utm.ip.zebb.models.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.user.UserDAO;

@Repository
public interface UserRepository {

    UserDAO setUser(final UserDAO product);
    UserDAO getUserThruUsername(String id);
    UserDAO updateProfile(final UserDAO user);
    List<UserDAO> getAllUser();
    
}
