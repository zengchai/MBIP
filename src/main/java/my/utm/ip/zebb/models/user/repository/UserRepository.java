package my.utm.ip.zebb.models.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.user.UserDAO;

@Repository
public interface UserRepository {

    UserDAO register(final UserDAO product);
    UserDAO login(String id);
    UserDAO updateProfile(final UserDAO user);
    List<UserDAO> getAllEmail();
}
