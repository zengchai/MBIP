package my.utm.ip.zebb.models.winner.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.zebb.models.winner.WinnerDAO;

public class WinnerRepository_JDBC implements WinnerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<WinnerDAO> getWinnersByUserAndMonth() {
        String sql = "SELECT " +
                    "recycledata.userName, recycledata.weight, recycledata.month, recycledata.image_name as recycle_image, recycledata.recycling_carbon_factor, " +
                    "electricaldata.electricityusage, electricaldata.image_name as electrical_image, electricaldata.electrical_carbon_factor, " +
                    "waterdata.waterusage, waterdata.image_name as water_image, waterdata.water_carbon_factor " +
                    "FROM recycledata " +
                    "JOIN electricaldata ON recycledata.userName = electricaldata.userName AND recycledata.month = electricaldata.month " +
                    "JOIN waterdata ON recycledata.userName = waterdata.userName AND recycledata.month = waterdata.month ";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WinnerDAO.class));
    }

    @Override
    public WinnerDAO updateWinner(WinnerDAO winner) {
         // Validate the length of the Username before proceeding
         if (winner.getUserName().length() > 50) {
            throw new IllegalArgumentException("Username exceeds maximum allowed length");
        }

        String sql = "UPDATE users SET Winner = ? WHERE Username = ?";
        Object[] args = { 
                winner.getMonth(),
                winner.getUserName() // Assuming you have a getUsername() method in WinnerDTO
        };

        jdbcTemplate.update(sql, args);

        return winner;
    }

    @Override
    public int getWinnerCountForMonth(String month) {
        String sql = "SELECT COUNT(*) FROM users WHERE Winner = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, month);
    }

    @Override
    public List<WinnerDAO> getWinners() {
        String sql = "SELECT users.Username, users.Winner, recycledata.weight, " +
              "electricaldata.electricityusage, waterdata.waterusage, " +
              "recycledata.recycling_carbon_factor, " +
              "electricaldata.electrical_carbon_factor, waterdata.water_carbon_factor " +
              "FROM users " +
              "JOIN recycledata ON users.Username = recycledata.userName AND users.Winner = recycledata.month " +
              "JOIN electricaldata ON users.Username = electricaldata.userName AND users.Winner = electricaldata.month " +
              "JOIN waterdata ON users.Username = waterdata.userName AND users.Winner = waterdata.month";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WinnerDAO.class));
    }

    @Override
    public boolean deleteWinnerByUsername(String userName) {
        String sql = "UPDATE users SET Winner = NULL WHERE Username = ?";
        int count = jdbcTemplate.update(sql, userName);

        return count > 0;
    }

}
