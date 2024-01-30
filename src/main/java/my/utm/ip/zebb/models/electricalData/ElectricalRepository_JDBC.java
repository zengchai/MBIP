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

        final List<ElectricalDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ElectricalDTO>(ElectricalDTO.class));

        return list;
    } 

    @Override
    public ElectricalDTO addElectricalData1(ElectricalDTO electrical) {
        String sql = "INSERT INTO electricaldata (userName, electricityusage, days, month, proportion_factor, amount, current_charge, image_name, image_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        };

        jdbcTemplate.update(sql, arg);

        return electrical;
    }

    @Override
    public ElectricalDTO addElectricalData2(ElectricalDTO electrical) {
        String sql = "INSERT INTO electricaldata (electricityusage, days, month, proportion_factor, amount, current_charge, image_name, image_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] arg = { 
            electrical.getElectricityusage(),
            electrical.getDays(),
            electrical.getMonth(),
            electrical.getProportion_factor(),
            electrical.getAmount(),
            electrical.getCurrent_charge(),
            electrical.getImageName(),
            electrical.getImageData(),
        };

        jdbcTemplate.update(sql, arg);

        return electrical;
    }

    @Override
    public ElectricalDTO getElectricalDataByUserName_month(String userName, String month) {
        String sql = "SELECT * FROM electricaldata WHERE userName=? AND month=?";
        ElectricalDTO electrical = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<ElectricalDTO>(ElectricalDTO.class),
                userName, month);
        return electrical;
    }

}

