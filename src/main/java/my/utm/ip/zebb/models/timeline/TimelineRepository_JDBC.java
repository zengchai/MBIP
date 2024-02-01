package my.utm.ip.zebb.models.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TimelineRepository_JDBC implements TimelineRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<TimelineDao> getAlltimeline(){

        String sql = "Select * FROM timeline ";
        final List<TimelineDao> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<TimelineDao>(TimelineDao.class));

        return list;
    }
}
