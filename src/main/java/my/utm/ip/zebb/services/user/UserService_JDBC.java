package my.utm.ip.zebb.services.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.models.user.UserDAO;
import my.utm.ip.zebb.models.user.repository.UserRepository;

public class UserService_JDBC implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public User setUser(User user){
        UserDAO newuser = user.toDAO();
        repo.setUser(newuser);
        return null;
    }

    @Override
    public User getUserThruUsername(String username){
        UserDAO existinguser = repo.getUserThruUsername(username);
        User user = new User();
        user.fromDAO(existinguser);

        return user;
    }

    @Override
    public User updateProfile(User user){
        UserDAO dao = repo.updateProfile(user.toDAO());
        return new User(dao);
    }

    @Override
    public List<User> getAllUser(){
        List<UserDAO> userList = repo.getAllUser();
        List<User> userDTOList = new ArrayList<>();
        for(UserDAO user:userList){
            userDTOList.add(new User(user));
        }
        return userDTOList;
    }
    
    @Override
    public int getAllUserNum(){
        List<User> userList = this.getAllUser();
        return userList.size();
    }
}
