package my.utm.ip.zebb.models.recycleData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class RecyclingRepository_JDBC implements RecyclingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RecyclingDTO> getAllRecycleData() {

        String sql = "SELECT * FROM recycledata";

        final List<RecyclingDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<RecyclingDTO>(RecyclingDTO.class));

        return list;
    } 

    @Override
    public RecyclingDTO addRecycleData1(RecyclingDTO recycle) {
        String sql = "INSERT INTO recycledata (userName, weight, days, month, image_name, image_data) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] arg = { 
                recycle.getUserName(),
                recycle.getWeight(),
                recycle.getDays(),
                recycle.getMonth(),
                recycle.getImageName(),
                recycle.getImageData(),
        };

        jdbcTemplate.update(sql, arg);

        return recycle;
    }

    @Override
    public RecyclingDTO addRecycleData2(RecyclingDTO recycle) { //for testing
        String sql = "INSERT INTO recycledata (weight, days, month, image_name, image_data) VALUES (?, ?, ?, ?, ?)";
        Object[] arg = { 
                recycle.getWeight(),
                recycle.getDays(),
                recycle.getMonth(),
                recycle.getImageName(),
                recycle.getImageData(),
        };

        jdbcTemplate.update(sql, arg);

        return recycle;
    }

    @Override
    public RecyclingDTO getRecycleDataByUserName_month(String userName, String month) {
        String sql = "SELECT * FROM recycledata WHERE userName=? AND month=?";
        RecyclingDTO recycle = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<RecyclingDTO>(RecyclingDTO.class),
                userName, month);
        return recycle;
    }

    // @Override
    // public RecyclingDTO updateRecycleData(final RecyclingDTO winner) {

    //     StringBuilder sql = new StringBuilder("UPDATE winners SET ");
        
    //     if (winner.getUserName()!= null){
    //         sql.append("userName'").append(winner.getUserName()).append("', ");
    //     }

    //     if (winner.getLocation()!= null){
    //         sql.append("location'").append(winner.getLocation()).append("', ");
    //     }

    //     Double water_consumption = winner.getWater_consumption();
    //     if (water_consumption!= null){
    //         sql.append("water_consumption=").append(winner.getWater_consumption()).append(", ");
    //     }

    //     Double electricity_consumption = winner.getElectricity_consumption();
    //     if (electricity_consumption!= null){
    //         sql.append("electricity_consumption=").append(winner.getElectricity_consumption()).append(", ");
    //     }

    //     Double recycling_amount = winner.getRecycling_amount();
    //     if (recycling_amount!= null){
    //         sql.append("recycling_amount=").append(winner.getRecycling_amount()).append(", ");
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

    // @Override
    // public boolean deleteRecycleData(String userName, String month) {
    //     String sql = "DELETE FROM winners WHERE userName=?";
    //     int count = jdbcTemplate.update(sql, userName);

    //     return count > 0;

    // }

}
