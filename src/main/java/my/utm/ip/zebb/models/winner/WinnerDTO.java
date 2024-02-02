package my.utm.ip.zebb.models.winner;

public class WinnerDTO {
    private String userName;
    private String month;
    private double waterusage;
    private double electricityusage;
    private double weight;
    private double carbon_reduction_rate;
    private String recycle_image;
    private String electrical_image;
    private String water_image;
    private double recycling_carbon_factor;
    private double electrical_carbon_factor;
    private double water_carbon_factor;
    private String Winner;

    public WinnerDTO(String userName, String month, double waterusage, double electricityusage,
            double weight, double carbon_reduction_rate, String recycle_image, String electrical_image, String water_image, double recycling_carbon_factor, 
            double electrical_carbon_factor, double water_carbon_factor, String Winner) {
        this.userName = userName;
        this.month = month;
        this.waterusage = waterusage;
        this.electricityusage = electricityusage;
        this.weight = weight;
        this.carbon_reduction_rate = carbon_reduction_rate;
        this.recycle_image=recycle_image;
        this.electrical_image=electrical_image;
        this.water_image=water_image;
        this.recycling_carbon_factor=recycling_carbon_factor;
        this.electrical_carbon_factor=electrical_carbon_factor;
        this.water_carbon_factor=water_carbon_factor;
        this.Winner=Winner;
    }

    public WinnerDTO() {
        this.userName="";
        this.month="";
        this.waterusage=0.0;
        this.electricityusage=0.0;
        this.weight=0.0;
        this.weight=0.0;
        this.recycle_image = "";
        this.electrical_image="";
        this.water_image="";
        this.recycling_carbon_factor=0.0;
        this.electrical_carbon_factor=0.0;
        this.water_carbon_factor=0.0;
        this.Winner="";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setwaterusage(double waterusage) {
        this.waterusage = waterusage;
    }

    public void setelectricityusage(double electricityusage) {
        this.electricityusage = electricityusage;
    }

    public void setweight(double weight) {
        this.weight = weight;
    }

    public void setCarbon_reduction_rate(double carbon_reduction_rate) {
        this.carbon_reduction_rate = carbon_reduction_rate;
    }

    public void setrecycle_image(String recycle_image) {
        this.recycle_image = recycle_image;
    }

    public void setwater_image(String water_image) {
        this.water_image = water_image;
    }

    public void setelectrical_image(String electrical_image) {
        this.electrical_image = electrical_image;
    }

    public void setRecycling_carbon_factor(double recycling_carbon_factor) {
        this.recycling_carbon_factor = recycling_carbon_factor;
    }

    public void setElectric_carbon_factor(double electrical_carbon_factor) {
        this.electrical_carbon_factor = electrical_carbon_factor;
    }

    public void setWater_carbon_factor(double water_carbon_factor) {
        this.water_carbon_factor = water_carbon_factor;
    }

    public void setWinner(String Winner) {
        this.Winner = Winner;
    }

    public String getUserName() {
        return userName;
    }

    public String getMonth() {
        return month;
    }

    public double getwaterusage() {
        return waterusage;
    }

    public double getelectricityusage() {
        return electricityusage;
    }

    public double getweight() {
        return weight;
    }

    public double getCarbon_reduction_rate() {
        return carbon_reduction_rate;
    }

    public String getrecycle_image() {
        return recycle_image;
    }

    public String getelectrical_image() {
        return electrical_image;
    }

    public String getwater_image() {
        return water_image;
    }

    public double getRecycling_carbon_factor() {
        return recycling_carbon_factor;
    }

    public double getElectric_carbon_factor() {
        return electrical_carbon_factor;
    }

    public double getWater_carbon_factor() {
        return water_carbon_factor;
    }

    public String getWinner() {
        return Winner;
    }

    @Override
    public String toString() {
        return "Winner [userName=" + userName + ", month=" + month + ", water consumption=" + waterusage + ", electricity consumption=" + electricityusage
                + ", recycling amount=" + weight + ", carbon reduction rate=" + carbon_reduction_rate + "]";
    }

      
}
