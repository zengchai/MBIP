package my.utm.ip.zebb.models.waterData;

import java.util.Arrays;

public class WaterDTO {
    String userName;
    double waterusage;
    int days;
    String month;
    double proportion_factor;
    double amount;
    String imageName;
    byte[] imageData;

    public WaterDTO() {
        this.userName = "";
        this.waterusage = 0.0;
        this.days = 0;
        this.month = "";
        this.proportion_factor = 0.0;
        this.amount = 0.0;
        this.imageName = "";
        this.imageData = new byte[0]; 
    }

    
    public WaterDTO(String userName, double waterusage, int days, String month, double proportion_factor, double amount,
             String imageName, byte[] imageData) {
        this.userName = userName;
        this.waterusage = waterusage;
        this.days = days;
        this.month = month;
        this.proportion_factor = proportion_factor;
        this.amount = amount;
        this.imageName = imageName;
        this.imageData = imageData;
    }


     public WaterDTO(double waterusage, int days, String month, double proportion_factor, double amount,
             String imageName, byte[] imageData) {
        this.waterusage = waterusage;
        this.days = days;
        this.month = month;
        this.proportion_factor = proportion_factor;
        this.amount = amount;
        this.imageName = imageName;
        this.imageData = imageData;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public double getWaterusage() {
        return waterusage;
    }


    public void setWaterusage(double waterusage) {
        this.waterusage = waterusage;
    }


    public int getDays() {
        return days;
    }


    public void setDays(int days) {
        this.days = days;
    }


    public String getMonth() {
        return month;
    }


    public void setMonth(String month) {
        this.month = month;
    }


    public double getProportion_factor() {
        return proportion_factor;
    }


    public void setProportion_factor(double proportion_factor) {
        this.proportion_factor = proportion_factor;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getImageName() {
        return imageName;
    }


    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public byte[] getImageData() {
        return imageData;
    }


    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }


    @Override
    public String toString() {
        return "WaterDTO [userName=" + userName + ", waterusage=" + waterusage + ", days=" + days + ", month=" + month
                + ", proportion_factor=" + proportion_factor + ", amount=" + amount + ", imageName=" + imageName
                + ", imageData=" + Arrays.toString(imageData) + "]";
    }

    
}
