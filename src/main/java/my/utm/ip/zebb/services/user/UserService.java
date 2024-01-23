package my.utm.ip.zebb.services.user;

import my.utm.ip.zebb.models.user.User;

public interface UserService {

    User register(final User user);
    User login(String username);
    User updateProfile(final User user);

}
