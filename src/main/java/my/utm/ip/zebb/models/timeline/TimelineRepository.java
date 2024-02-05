package my.utm.ip.zebb.models.timeline;
import java.util.List;


import org.springframework.stereotype.Repository;
import my.utm.ip.zebb.models.timeline.TimelineDao;

@Repository
public interface TimelineRepository {
    List<TimelineDao>getAlltimeline();
    TimelineDao addNewEvent(TimelineDao dao);
    TimelineDao getEventByName(String name); 
    TimelineDao updateEvent(final TimelineDao dao);
    public boolean deleteEventById(int id);
}
