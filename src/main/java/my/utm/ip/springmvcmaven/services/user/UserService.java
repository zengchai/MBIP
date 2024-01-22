package my.utm.ip.springmvcmaven.services.user;

import my.utm.ip.springmvcmaven.models.user.User;

public interface UserService {

    User register(final User user);
    User login(String username);
    User updateProfile(final User user);

}
