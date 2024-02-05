package my.utm.ip.zebb.services.timeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.timeline.Timeline;
import my.utm.ip.zebb.models.timeline.TimelineDao;
import my.utm.ip.zebb.models.timeline.TimelineRepository;
import my.utm.ip.zebb.models.user.User;


public class TimelineService_JDBC implements TimelineService{
    @Autowired
    TimelineRepository repo;

    @Override
    public List<Timeline> getAlltimeline(){
        List<TimelineDao> tList = repo.getAlltimeline();
        List<Timeline> timelineList = new ArrayList<Timeline>();
        for(TimelineDao timeline:tList){
           timelineList.add(new Timeline(timeline));
        }
        return timelineList;
    }
    @Override
    public Timeline addNewEvent(Timeline timeline){
        TimelineDao nEvent=repo.addNewEvent(timeline.toDAO());
        return new Timeline(nEvent);
    }
    //  @Override
    // public Timeline getAllEventId(){
    //     List<Timeline> eventList = this.getAlltimeline();
    //     return eventList.size();
    // }

    @Override
    public Timeline updateEvent(Timeline timeline) {
        TimelineDao updatedEventDao = repo.updateEvent(timeline.toDAO());
        return new Timeline(updatedEventDao);
        
    }
    @Override
    public Timeline getEventByName(String name) {
        TimelineDao dto=repo.getEventByName(name);
        Timeline event=new Timeline();
        event.fromDAO(dto);
        return event;
    }

    @Override
    public boolean deleteEventById(int id) {
        boolean success=repo.deleteEventById(id);
        return success;

    }
}
