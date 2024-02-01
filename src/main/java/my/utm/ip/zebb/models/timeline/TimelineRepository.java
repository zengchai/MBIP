package my.utm.ip.zebb.models.timeline;
import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.timeline.TimelineDao;
@Repository
public interface TimelineRepository {
    List<TimelineDao>getAlltimeline();
}
