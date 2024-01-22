package my.utm.ip.zebb.services.user;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.models.user.UserDAO;
import my.utm.ip.zebb.models.user.repository.UserRepository;

public class UserService_JDBC implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public User register(User user){
        UserDAO newuser = user.toDAO();
        repo.register(newuser);
        return null;
    }

    @Override
    public User login(String username){
        UserDAO existinguser = repo.login(username);
        User user = new User();
        user.fromDAO(existinguser);

        return user;
    }

    @Override
    public User updateProfile(User user){
        UserDAO dao = repo.updateProfile(user.toDAO());
        return new User(dao);
    }
    
}
