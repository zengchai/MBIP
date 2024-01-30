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
    public RecyclingDTO addRecycleData(RecyclingDTO recycle) {
        String checkIfExistsSql = "SELECT COUNT(*) FROM recycledata WHERE month = ? ";

        int existingCount = jdbcTemplate.queryForObject(checkIfExistsSql, Integer.class, recycle.getMonth());
            
            if (existingCount > 0) {
                // data already exists
                String sql = "UPDATE recycledata SET userName=?, weight=?, month=?, image_name=?, image_data=?, recycling_carbon_factor=? WHERE month=?";
                Object[] arg = { 
                        recycle.getUserName(),
                        recycle.getWeight(),
                        recycle.getMonth(),
                        recycle.getImageName(),
                        recycle.getImageData(),
                        recycle.getRecycling_carbon_factor(),
                        recycle.getMonth()
                };
                jdbcTemplate.update(sql, arg);

            } else {
                // Car does not exist, add a new entry
                String sql = "INSERT INTO recycledata (userName, weight, month, image_name, image_data, recycling_carbon_factor) VALUES (?, ?, ?, ?, ?, ?)";
                Object[] arg = { 
                    recycle.getUserName(),
                    recycle.getWeight(),
                    recycle.getMonth(),
                    recycle.getImageName(),
                    recycle.getImageData(),
                    recycle.getRecycling_carbon_factor(),
                };
                jdbcTemplate.update(sql, arg);
            }
        
        return recycle;

    }

    @Override
    public List<RecyclingDTO> getRecycleDataByUserName(String userName) {
        String sql = "SELECT * FROM recycledata WHERE userName=?";
        
        List<RecyclingDTO> recycleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<RecyclingDTO>(RecyclingDTO.class), userName);

        return recycleList;
    }

    @Override
    public RecyclingDTO updateRecycleData(final RecyclingDTO recycle) {
        String sql = "UPDATE recycledata SET userName=?, weight=?, month=?, image_name=?, image_data=?, recycling_carbon_factor=? WHERE month=?";
        Object[] arg = { 
                recycle.getUserName(),
                recycle.getWeight(),
                recycle.getMonth(),
                recycle.getImageName(),
                recycle.getImageData(),
                recycle.getRecycling_carbon_factor(),
                recycle.getMonth()
        };

        int count = jdbcTemplate.update(sql, arg);

        if (count>0)
            return recycle;

        return null;

    }

    @Override
    public boolean deleteRecycleData(String month) {
        String sql = "DELETE FROM recycledata WHERE month=?";
        int count = jdbcTemplate.update(sql, month);

        return count > 0;

    }

}
