package my.utm.ip.zebb.models.recycleData;

public class RecyclingDAO {
    private String userName;
    private double weight;
    private String month;
    private String imageName;
    private byte[] imageData;
    private double recycling_carbon_factor;

    public RecyclingDAO(String userName, double weight, String month, String imageName, byte[] imageData, double recycling_carbon_factor ) {
        this.userName = userName;
        this.weight = weight;
        this.month = month;
        this.imageName = imageName;
        this.imageData = imageData;
        this.recycling_carbon_factor = recycling_carbon_factor;
    }

    public RecyclingDAO() {
        this.userName = "";
        this.weight = 0.0;
        this.month = "";
        this.imageName = "";
        this.imageData = new byte[0]; 
        this.recycling_carbon_factor=0.0;
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

    @Override
   public String toString() {
       return "Recycling data [userName=" + userName + ", weight=" + weight + ", month=" + month + ", imageName=" + imageName
               + ", imageData=" + imageData + ", recycling_carbon_factor=" + recycling_carbon_factor +"]";
   }

      
}
