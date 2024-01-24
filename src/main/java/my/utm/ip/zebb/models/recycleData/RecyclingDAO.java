package my.utm.ip.zebb.models.recycleData;

public class RecyclingDAO {
    String userName;
    double weight;
    int days;
    String month;
    String imageName;
    byte[] imageData;
    double recycling_carbon_factor;

    public RecyclingDAO() {
        this.userName = "";
        this.weight = 0.0;
        this.days = 0;
        this.month = "";
        this.imageName = "";
        this.imageData = new byte[0]; 
        this.recycling_carbon_factor=0.0;
    }

    public RecyclingDAO(String userName, double weight, int days, String month, String imageName, byte[] imageData, double recycling_carbon_factor) {
        this.userName = userName;
        this.weight = weight;
        this.days = days;
        this.month = month;
        this.imageName = imageName;
        this.imageData = imageData;
        this.recycling_carbon_factor = recycling_carbon_factor;
    }

    public void assign(RecyclingDAO recycling) {
        this.userName = recycling.userName;
        this.weight = recycling.weight;
        this.days = recycling.days;
        this.month = recycling.month;
        this.imageName = recycling.imageName;
        this.imageData = recycling.imageData;
        this.recycling_carbon_factor = recycling.recycling_carbon_factor;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setRecycling_carbon_factor(double recycling_carbon_factor) {
        this.recycling_carbon_factor = recycling_carbon_factor;
    }

    public String getUserName() {
        return userName;
    }

    public double getWeight() {
        return weight;
    }

    public int getDays() {
        return days;
    }

    public String getMonth() {
        return month;
    }

    public String getImageName() {
        return imageName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public double getRecycling_carbon_factor() {
        return recycling_carbon_factor;
    }

    // methods to faciliate DTO
    public void fromDTO(final RecyclingDTO dto) {

        this.userName = dto.getUserName();
        this.weight = dto.getWeight();
        this.days = dto.getDays();
        this.month = dto.getMonth();
        this.imageName = dto.getImageName();
        this.imageData = dto.getImageData();
        this.recycling_carbon_factor=dto.getRecycling_carbon_factor();

    }

    public RecyclingDTO toDTO() {
        RecyclingDTO dto = new RecyclingDTO();
        dto.setUserName(this.userName);
        dto.setWeight(this.weight);
        dto.setDays(this.days);
        dto.setMonth(this.month);
        dto.setImageName(this.imageName);
        dto.setImageData(this.imageData);
        dto.setRecycling_carbon_factor(this.recycling_carbon_factor);

        return dto;
    }

    public RecyclingDAO(final RecyclingDTO dto){
        this.fromDTO(dto);
    }

   // methods to faciliate debugging

   @Override
   public String toString() {
       return "Recycling data [userName=" + userName + ", weight=" + weight + ", days=" + days +  ", month=" + month + ", imageName=" + imageName
               + ", imageData=" + imageData + ", recycling_carbon_factor=" + recycling_carbon_factor +"]";
   }



}
