package my.utm.ip.zebb.models.timeline;

public class TimelineDao {
    private String month;
    private String title;
    private String description;

    public TimelineDao(){
        this.month=" ";
        this.title=" ";
        this.description="";
    }

    public TimelineDao(String month, String title, String description) {
        this.month = month;
        this.title = title;
        this.description = description;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
