package my.utm.ip.zebb.models.timeline;

public class Timeline {
    private String month;
    private String title;
    private String description;
    private int id;

    public Timeline() {
        this.id = 0;
        this.month = " ";
        this.title = " ";
        this.description = "";
    }

    public Timeline(String month, String title, String description) {

        this.month = month;
        this.title = title;
        this.description = description;
    }

    public Timeline(int id, String month, String title, String description) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void fromDAO(final TimelineDao dao) {
        this.month = dao.getMonth();
        this.title = dao.getTitle();
        this.description = dao.getDescription();
        this.id = dao.getId();
    }

    public TimelineDao toDAO() {
        TimelineDao dao = new TimelineDao();
        dao.setMonth(this.month);
        dao.setTitle(this.title);
        dao.setDescription(this.description);
        dao.setId(this.id);
        return dao;
    }

    public Timeline(final TimelineDao dao) {
        this.fromDAO(dao);
    }

    @Override
    public String toString() {
        return "Timeline data: " + month + "title: " + title + "Description: " + description;
    }

    public boolean isPresent() {
        throw new UnsupportedOperationException("Unimplemented method 'isPresent'");
    }
}
