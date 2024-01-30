package my.utm.ip.zebb.services.user;

import java.util.List;

import my.utm.ip.zebb.models.user.User;

public interface UserService {

    User register(final User user);
    User login(String username);
    User updateProfile(final User user);
    List<User> getAllEmail();

}
