package my.utm.ip.zebb.services.timeline;
import java.util.List;

import my.utm.ip.zebb.models.timeline.Timeline;

public interface TimelineService {
    
    List<Timeline>getAlltimeline();
    Timeline addNewEvent(final Timeline timeline);
    Timeline getEventByName(String Name);  
    Timeline updateEvent(Timeline timeline);
    boolean deleteEventById(int id);
}