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
    public WinnerDTO addWinner(WinnerDTO winner) {
        String sql = "INSERT INTO winners (userName, location, water_consumption, electricity_consumption, recycling_amount, carbon_reduction_rate) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] arg = { 
                winner.getUserName(),
                winner.getLocation(),
                winner.getWater_consumption(),
                winner.getElectricity_consumption(),
                winner.getRecycling_amount(),
                winner.getCarbon_reduction_rate()
        };

        jdbcTemplate.update(sql, arg);

        return winner;
    }

    @Override
    public WinnerDTO getWinnerByUserName(String userName) {
        String sql = "SELECT * FROM winners WHERE userName=?";
        WinnerDTO winner = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<WinnerDTO>(WinnerDTO.class),
                userName);
        return winner;
    }

    @Override
    public WinnerDTO updateWinner(final WinnerDTO winner) {

        StringBuilder sql = new StringBuilder("UPDATE winners SET ");
        
        if (winner.getUserName()!= null){
            sql.append("userName'").append(winner.getUserName()).append("', ");
        }

        if (winner.getLocation()!= null){
            sql.append("location'").append(winner.getLocation()).append("', ");
        }

        Double water_consumption = winner.getWater_consumption();
        if (water_consumption!= null){
            sql.append("water_consumption=").append(winner.getWater_consumption()).append(", ");
        }

        Double electricity_consumption = winner.getElectricity_consumption();
        if (electricity_consumption!= null){
            sql.append("electricity_consumption=").append(winner.getElectricity_consumption()).append(", ");
        }

        Double recycling_amount = winner.getRecycling_amount();
        if (recycling_amount!= null){
            sql.append("recycling_amount=").append(winner.getRecycling_amount()).append(", ");
        }

        Double carbon_reduction_rate = winner.getCarbon_reduction_rate();
        if (carbon_reduction_rate!= null){
            sql.append("carbon_reduction_rate=").append(winner.getCarbon_reduction_rate()).append(", ");
        }

        sql.append("WHERE userName=?");
        

        int count = jdbcTemplate.update(sql.toString(), winner.getUserName());

        if (count>0)
            return winner;

        return null;

    }

    @Override
    public boolean deleteWinner(String userName) {
        String sql = "DELETE FROM winners WHERE userName=?";
        int count = jdbcTemplate.update(sql, userName);

        return count > 0;

    }

}
