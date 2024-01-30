package my.utm.ip.zebb.models.user.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.zebb.models.user.UserDAO;

public class UserRepository_JDBC implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDAO register(final UserDAO user){

        
        String sql = "INSERT INTO users (Email, Password, Username, Level) VALUES (?,?,?,?);";
        Object[] arg = { user.getEmail(),
            user.getPassword(),
            user.getUsername(),
            "1"};
        
        jdbcTemplate.update(sql, arg);

        return null;
    }

    public UserDAO login(String username){
        String sql = "SELECT * FROM users WHERE Username=?";
        try {
            UserDAO user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserDAO.class), username);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return new UserDAO();
        }
    }

    @Override
    public UserDAO updateProfile(final UserDAO user) {

        StringBuilder sql = new StringBuilder("UPDATE users SET ");
        
        if (user.getFullname()!= null){
            sql.append("Fullname='").append(user.getFullname()).append("', ");
        }
        
        if (user.getNickname()!= null){
            sql.append("Nickname='").append(user.getNickname()).append("', ");
        }
        
        if (user.getEmail()!= null){
            sql.append("Email='").append(user.getEmail()).append("', ");
        }

        if (user.getPhoneNum()!= null){
            sql.append("PhoneNum='").append(user.getPhoneNum()).append("', ");
        }

        if (user.getCategory()!= null){
            sql.append("Category='").append(user.getCategory()).append("', ");
        }

        if (user.getPreferredLanguage()!= null){
            sql.append("PreferredLanguage='").append(user.getPreferredLanguage()).append("', ");
        }

        if (user.getPoscode()!= null){
            sql.append("Poscode='").append(user.getPoscode()).append("', ");
        }

        if (user.getAddress()!= null){
            sql.append("Address='").append(user.getAddress()).append("' ");
        }
      sql.append("WHERE Username=?");
        
        int count = jdbcTemplate.update(sql.toString(), user.getUsername());

        if (count>0)
            return user;

        return null;

    }

    public List<UserDAO> getAllEmail(){

        String sql = "Select * from users";
        List<UserDAO> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDAO.class));
        return user;

    }
}
