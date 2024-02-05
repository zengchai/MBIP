package my.utm.ip.zebb.models.timeline;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import my.utm.ip.zebb.models.user.UserDAO;

public class TimelineRepository_JDBC implements TimelineRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TimelineDao> getAlltimeline() {

        String sql = "Select * FROM timeline ";
        final List<TimelineDao> list = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<TimelineDao>(TimelineDao.class));
        return list;
    }

    @Override
    public TimelineDao addNewEvent(TimelineDao dao) {
        String sql = "INSERT INTO timeline (month, title, description) VALUES (?, ?, ?)";
        Object[] arg = { dao.getMonth(), dao.getTitle(), dao.getDescription() };
        jdbcTemplate.update(sql, arg);
        return dao;
    }

    @Override
    public TimelineDao getEventByName(String name) {
        String sql = "SELECT * FROM timeline WHERE name= ?";
        try {
            TimelineDao event = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(TimelineDao.class), name);
            return event;
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if event with given ID is not found
        }
    }

    @Override
    public TimelineDao updateEvent(final TimelineDao timeline) {
        String sql = "UPDATE timeline SET month=?, title=?, description=? WHERE id=?";
        Object[] arg = {
                timeline.getMonth(),
                timeline.getTitle(),
                timeline.getDescription(),
                timeline.getId()
        };

        int count = jdbcTemplate.update(sql, arg);
        if (count > 0)
            return timeline;
        return null;
    }

    @Override
    public boolean deleteEventById(int id) {
        String sql = "DELETE FROM timeline WHERE id=?";
        int count = jdbcTemplate.update(sql, id);
        return count > 0;

    }
}
