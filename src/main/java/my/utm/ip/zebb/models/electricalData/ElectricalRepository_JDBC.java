package my.utm.ip.zebb.models.electricalData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ElectricalRepository_JDBC implements ElectricalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ElectricalDTO> getAllElectricalData() {

        String sql = "SELECT * FROM electricaldata";

        final List<ElectricalDTO> list = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<ElectricalDTO>(ElectricalDTO.class));

        return list;
    }

    @Override
    public ElectricalDTO addElectricalData(ElectricalDTO electrical) {
        String checkIfExistsSql = "SELECT COUNT(*) FROM electricaldata WHERE month = ? ";

        int existingCount = jdbcTemplate.queryForObject(checkIfExistsSql, Integer.class, electrical.getMonth());

        if (existingCount > 0) {
            // data already exists
            String sql = "UPDATE electricaldata SET username=?, electricityusage=?, days=?, month=?, proportion_factor=?,amount=?,current_charge=?,image_name=?, image_data=? ,electrical_carbon_factor=? WHERE month=?";
            Object[] arg = {
                    electrical.getUserName(),
                    electrical.getElectricityusage(),
                    electrical.getDays(),
                    electrical.getMonth(),
                    electrical.getProportion_factor(),
                    electrical.getAmount(),
                    electrical.getCurrent_charge(),
                    electrical.getImageName(),
                    electrical.getImageData(),
                    electrical.getElectrical_carbon_factor(),
                    electrical.getMonth(),

            };
            jdbcTemplate.update(sql, arg);

        } else {
            String sql = "INSERT INTO electricaldata (userName, electricityusage, days, month, proportion_factor, amount, current_charge, image_name, image_data,electrical_carbon_factor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] arg = {
                    electrical.getUserName(),
                    electrical.getElectricityusage(),
                    electrical.getDays(),
                    electrical.getMonth(),
                    electrical.getProportion_factor(),
                    electrical.getAmount(),
                    electrical.getCurrent_charge(),
                    electrical.getImageName(),
                    electrical.getImageData(),
                    electrical.getElectrical_carbon_factor(),
            };
            jdbcTemplate.update(sql, arg);
        }

        return electrical;

    }

    @Override
    public List<ElectricalDTO> getElectricalDataByUserName(String userName) {
        String sql = "SELECT * FROM electricaldata WHERE userName=?";

        List<ElectricalDTO> electricalList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<ElectricalDTO>(ElectricalDTO.class), userName);

        return electricalList;
    }

    @Override
    public ElectricalDTO updateElectricalData(final ElectricalDTO electrical) {
        String sql = "UPDATE electricaldata SET username=?, electricityusage=?, days=?, month=?, proportion_factor=?,amount=?,current_charge=?,image_name=?, image_data=?,electrical_carbon_factor=? WHERE month=?";
        Object[] arg = {
                electrical.getUserName(),
                electrical.getElectricityusage(),
                electrical.getDays(),
                electrical.getMonth(),
                electrical.getProportion_factor(),
                electrical.getAmount(),
                electrical.getCurrent_charge(),
                electrical.getImageName(),
                electrical.getImageData(),
                electrical.getElectrical_carbon_factor(),
                electrical.getMonth(),
        };

        int count = jdbcTemplate.update(sql, arg);

        if (count > 0)
            return electrical;

        return null;

    }

    @Override
    public boolean deleteElectricalData(String month) {
        String sql = "DELETE FROM electricaldata WHERE month=?";
        int count = jdbcTemplate.update(sql, month);

        return count > 0;

    }

}
