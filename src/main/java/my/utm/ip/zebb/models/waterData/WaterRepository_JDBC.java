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
    public WaterDTO addWaterData(WaterDTO water) {
        String checkIfExistsSql = "SELECT COUNT(*) FROM waterdata WHERE month = ? ";

        int existingCount = jdbcTemplate.queryForObject(checkIfExistsSql, Integer.class, water.getMonth());
            
            if (existingCount > 0) {
                // data already exists
                String sql = "UPDATE waterdata SET userName=?, waterusage=?, days=?, month=?, proportion_factor=?, amount=?, image_name=?, image_data=?, water_carbon_factor=? WHERE month=?";
                Object[] arg = { 
                        water.getUserName(),
                        water.getWaterusage(),
                        water.getDays(),
                        water.getMonth(),
                        water.getProportion_factor(),
                        water.getAmount(),
                        water.getImageName(),
                        water.getImageData(),
                        water.getWater_carbon_factor(),
                        water.getMonth(),
                };
                jdbcTemplate.update(sql, arg);

            } else {
                // Car does not exist, add a new entry
                String sql = "INSERT INTO waterdata (userName, waterusage, days, month, proportion_factor, amount, image_name, image_data, water_carbon_factor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                Object[] arg = { 
                    water.getUserName(),
                    water.getWaterusage(),
                    water.getDays(),
                    water.getMonth(),
                    water.getProportion_factor(),
                    water.getAmount(),
                    water.getImageName(),
                    water.getImageData(),
                    water.getWater_carbon_factor(),
                };
                jdbcTemplate.update(sql, arg);
            }
        
        return water;

    }

    @Override
    public List<WaterDTO> getWaterDataByUserName(String userName) {
        String sql = "SELECT * FROM waterdata WHERE userName=?";
        
        List<WaterDTO> waterList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<WaterDTO>(WaterDTO.class), userName);

        return waterList;
    }

    @Override
    public WaterDTO updateWaterData(final WaterDTO water) {
        String sql = "UPDATE waterdata SET userName=?, waterusage=?, days=?, month=?, proportion_factor=?, amount=?, image_name=?, image_data=? ,water_carbon_factor=? WHERE month=?";
        Object[] arg = { 
            water.getUserName(),
            water.getWaterusage(),
            water.getDays(),
            water.getMonth(),
            water.getProportion_factor(),
            water.getAmount(),
            water.getImageName(),
            water.getImageData(),
            water.getWater_carbon_factor(),
            water.getMonth(),
        };

        int count = jdbcTemplate.update(sql, arg);

        if (count>0)
            return water;

        return null;

    }

    @Override
    public boolean deleteWaterData(String month) {
        String sql = "DELETE FROM waterdata WHERE month=?";
        int count = jdbcTemplate.update(sql, month);

        return count > 0;

    }

}

