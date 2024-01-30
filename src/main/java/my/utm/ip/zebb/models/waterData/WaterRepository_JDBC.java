package my.utm.ip.zebb.models.waterData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class WaterRepository_JDBC implements WaterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<WaterDTO> getAllWaterData() {

        String sql = "SELECT * FROM waterdata";

        final List<WaterDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<WaterDTO>(WaterDTO.class));

        return list;
    } 

    @Override
    public WaterDTO addWaterData1(WaterDTO water) {
        String sql = "INSERT INTO waterdata (userName, waterusage, days, month, proportion_factor, amount, image_name, image_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] arg = { 
            water.getUserName(),
            water.getWaterusage(),
            water.getDays(),
            water.getMonth(),
            water.getProportion_factor(),
            water.getAmount(),
            water.getImageName(),
            water.getImageData(),
        };

        jdbcTemplate.update(sql, arg);

        return water;
    }

    @Override
    public WaterDTO addWaterData2(WaterDTO water) {
        String sql = "INSERT INTO waterdata (waterusage, days, month, proportion_factor, amount, image_name, image_data) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] arg = { 
            water.getWaterusage(),
            water.getDays(),
            water.getMonth(),
            water.getProportion_factor(),
            water.getAmount(),
            water.getImageName(),
            water.getImageData(),
        };

        jdbcTemplate.update(sql, arg);

        return water;
    }

    @Override
    public WaterDTO getWaterDataByUserName_month(String userName, String month) {
        String sql = "SELECT * FROM waterdata WHERE userName=? AND month=?";
        WaterDTO water = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<WaterDTO>(WaterDTO.class),
                userName, month);
        return water;
    }

}

