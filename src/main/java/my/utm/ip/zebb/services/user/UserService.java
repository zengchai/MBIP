package my.utm.ip.zebb.services.user;

import java.util.List;

import my.utm.ip.zebb.models.user.User;

public interface UserService {

    User setUser(final User user);
    User getUserThruUsername(String username);
    User updateProfile(final User user);
    List<User> getAllUser();
    int getAllUserNum();

}
