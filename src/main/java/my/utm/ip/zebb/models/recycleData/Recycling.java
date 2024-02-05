package my.utm.ip.zebb.models.recycleData;

public class Recycling {
    private String userName;
    private double weight;
    private String month;
    private String imageName;
    private byte[] imageData;
    private double recycling_carbon_factor;

    public Recycling() {
        this.userName = "";
        this.weight = 0.0;
        this.month = "";
        this.imageName = "";
        this.imageData = new byte[0]; 
        this.recycling_carbon_factor=0.0;
    }

    public Recycling(String userName, double weight, String month, String imageName, byte[] imageData, double recycling_carbon_factor) {
        this.userName = userName;
        this.weight = weight;
        this.month = month;
        this.imageName = imageName;
        this.imageData = imageData;
        this.recycling_carbon_factor = recycling_carbon_factor;
    }

    public void assign(Recycling recycling) {
        this.userName = recycling.userName;
        this.weight = recycling.weight;
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
    public void fromDAO(final RecyclingDAO dao) {

        this.userName = dao.getUserName();
        this.weight = dao.getWeight();
        this.month = dao.getMonth();
        this.imageName = dao.getImageName();
        this.imageData = dao.getImageData();
        this.recycling_carbon_factor=dao.getRecycling_carbon_factor();

    }

    public RecyclingDAO toDAO() {
        RecyclingDAO dao = new RecyclingDAO();
        dao.setUserName(this.userName);
        dao.setWeight(this.weight);
        dao.setMonth(this.month);
        dao.setImageName(this.imageName);
        dao.setImageData(this.imageData);
        dao.setRecycling_carbon_factor(this.recycling_carbon_factor);

        return dao;
    }
    
    public Recycling(final RecyclingDAO dto){
        this.fromDAO(dto);
    }

   // methods to faciliate debugging

   @Override
   public String toString() {
       return "Recycling data [userName=" + userName + ", weight=" + weight + ", month=" + month + ", imageName=" + imageName
               + ", imageData=" + imageData + ", recycling_carbon_factor=" + recycling_carbon_factor +"]";
   }



}
