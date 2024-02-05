package my.utm.ip.zebb.models.electricalData;

import java.util.Arrays;

public class Electrical {
    private String userName;
    private double electricityusage;
    private int days;
    private String month;
    private double proportion_factor;
    private double amount;
    private double current_charge;
    private String imageName;
    private byte[] imageData;
    private double electrical_carbon_factor;

    public Electrical() {
        this.userName = "";
        this.electricityusage = 0.0;
        this.days = 0;
        this.month = "";
        this.proportion_factor = 0.0;
        this.amount = 0.0;
        this.current_charge = 0.0;
        this.imageName = "";
        this.imageData = new byte[0]; 
        this.electrical_carbon_factor = 0.0;
    }

    
    public Electrical(String userName, double electricityusage, int days, String month, double proportion_factor, double amount,
            double current_charge, String imageName, byte[] imageData,double electrical_carbon_factor) {
        this.userName = userName;
        this.electricityusage = electricityusage;
        this.days = days;
        this.month = month;
        this.proportion_factor = proportion_factor;
        this.amount = amount;
        this.current_charge = current_charge;
        this.imageName = imageName;
        this.imageData = imageData;
        this.electrical_carbon_factor = electrical_carbon_factor;
    }

    public void assign(Electrical electrical) {
        this.userName = electrical.userName;
        this.electricityusage = electrical.electricityusage;
        this.days = electrical.days;
        this.month = electrical.month;
        this.proportion_factor = electrical.proportion_factor;
        this.amount = electrical.amount;
        this.current_charge = electrical.current_charge;
        this.imageName = electrical.imageName;
        this.imageData = electrical.imageData;
        this.electrical_carbon_factor = electrical_carbon_factor;
        
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public double getElectricityusage() {
        return electricityusage;
    }


    public void setElectricityusage(double electricityusage) {
        this.electricityusage = electricityusage;
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


    public double getCurrent_charge() {
        return current_charge;
    }


    public void setCurrent_charge(double current_charge) {
        this.current_charge = current_charge;
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
    
    
    public double getElectrical_carbon_factor() {
        return electrical_carbon_factor;
    }


    public void setElectrical_carbon_factor(double electrical_carbon_factor) {
        this.electrical_carbon_factor = electrical_carbon_factor;
    }

    // methods to faciliate DTO
    public void fromDAO(final ElectricalDAO dao) {
        this.userName = dao.getUserName();
        this.electricityusage = dao.getElectricityusage();
        this.days = dao.getDays();
        this.month = dao.getMonth();
        this.proportion_factor = dao.getProportion_factor();
        this.amount = dao.getAmount();
        this.current_charge = dao.getCurrent_charge();
        this.imageName = dao.getImageName();
        this.imageData = dao.getImageData();
        this.electrical_carbon_factor = dao.getElectrical_carbon_factor();

    }

    public ElectricalDAO toDAO() {
        ElectricalDAO dao = new ElectricalDAO();
        dao.setUserName(this.userName);
        dao.setElectricityusage(this.electricityusage);
        dao.setDays(this.days);
        dao.setMonth(this.month);
        dao.setProportion_factor(this.proportion_factor);
        dao.setAmount(this.amount);
        dao.setCurrent_charge(this.current_charge);
        dao.setImageName(this.imageName);
        dao.setImageData(this.imageData);
        dao.setElectrical_carbon_factor(this.electrical_carbon_factor);

        return dao;
    }

    public Electrical(final ElectricalDAO dao){
        this.fromDAO(dao);
    }


    @Override
    public String toString() {
        return "ElectricalDAO [userName=" + userName + ", electricityusage=" + electricityusage + ", days=" + days
                + ", month=" + month + ", proportion_factor=" + proportion_factor + ", amount=" + amount
                + ", current_charge=" + current_charge + ", imageName=" + imageName + ", imageData="
                + Arrays.toString(imageData) + ", electrical_carbon_factor=" + electrical_carbon_factor + "]";
    }


    


}
