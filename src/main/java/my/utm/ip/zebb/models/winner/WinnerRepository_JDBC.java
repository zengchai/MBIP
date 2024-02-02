package my.utm.ip.zebb.models.winner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class WinnerRepository_JDBC implements WinnerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<WinnerDTO> getAllWinners() {

        String sql = "SELECT * FROM winners";

        final List<WinnerDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<WinnerDTO>(WinnerDTO.class));

        return list;
    } 

    @Override
    public List<WinnerDTO> getWinnersByUserAndMonth() {
        String sql = "SELECT " +
                    "recycledata.userName, recycledata.weight, recycledata.month, recycledata.image_name as recycle_image, recycledata.recycling_carbon_factor, " +
                    "electricaldata.electricityusage, electricaldata.image_name as electrical_image, electricaldata.electric_carbon_factor, " +
                    "waterdata.waterusage, waterdata.image_name as water_image, waterdata.water_carbon_factor " +
                    "FROM recycledata " +
                    "JOIN electricaldata ON recycledata.userName = electricaldata.userName AND recycledata.month = electricaldata.month " +
                    "JOIN waterdata ON recycledata.userName = waterdata.userName AND recycledata.month = waterdata.month ";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WinnerDTO.class));
    }

    // @Override
    // public WinnerDTO updateWinner(WinnerDTO winner) {
    //     String sql = "UPDATE users SET Winner = ? WHERE Username = ?";
    //     Object[] args = { 
    //             winner.getMonth(),
    //             winner.getUserName() // Assuming you have a getUsername() method in WinnerDTO
    //     };

    //     jdbcTemplate.update(sql, args);

    //     return winner;
    // }

    @Override
    public WinnerDTO updateWinner(WinnerDTO winner) {
        // Assuming you have a Winner table with columns Username and Winner
        String sql = "INSERT INTO users (Username, Winner) VALUES (?, ?) ON DUPLICATE KEY UPDATE Winner = ?";
        
        Object[] args = { 
            winner.getUserName(),
            winner.getMonth(),
            winner.getMonth()
        };

        jdbcTemplate.update(sql, args);

        return winner;
    }






    // @Override
    // public WinnerDTO updateWinner(final WinnerDTO winner) {

    //     StringBuilder sql = new StringBuilder("UPDATE winners SET ");
        
    //     if (winner.getUserName()!= null){
    //         sql.append("userName'").append(winner.getUserName()).append("', ");
    //     }

    //     if (winner.getMonth()!= null){
    //         sql.append("location'").append(winner.getMonth()).append("', ");
    //     }

    //     Double water_consumption = winner.getwaterusage();
    //     if (water_consumption!= null){
    //         sql.append("water_consumption=").append(winner.getwaterusage()).append(", ");
    //     }

    //     Double electricity_consumption = winner.getelectricityusage();
    //     if (electricity_consumption!= null){
    //         sql.append("electricity_consumption=").append(winner.getelectricityusage()).append(", ");
    //     }

    //     Double recycling_amount = winner.getweight();
    //     if (recycling_amount!= null){
    //         sql.append("recycling_amount=").append(winner.getweight()).append(", ");
    //     }

    //     Double carbon_reduction_rate = winner.getCarbon_reduction_rate();
    //     if (carbon_reduction_rate!= null){
    //         sql.append("carbon_reduction_rate=").append(winner.getCarbon_reduction_rate()).append(", ");
    //     }

    //     sql.append("WHERE userName=?");
        

    //     int count = jdbcTemplate.update(sql.toString(), winner.getUserName());

    //     if (count>0)
    //         return winner;

    //     return null;

    // }

    @Override
    public boolean deleteWinner(String userName) {
        String sql = "DELETE FROM winners WHERE userName=?";
        int count = jdbcTemplate.update(sql, userName);

        return count > 0;

    }

}
