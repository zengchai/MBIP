package my.utm.ip.zebb.models.winner;

public class WinnerDAO {
    String userName;
    String location;
    double water_consumption;
    double electricity_consumption;
    double recycling_amount;
    double carbon_reduction_rate;

    public WinnerDAO() {
        this.userName="";
        this.location="";
        this.water_consumption=0.0;
        this.electricity_consumption=0.0;
        this.recycling_amount=0.0;
        this.recycling_amount=0.0;
    }

    public WinnerDAO(String userName, String location, double water_consumption, double electricity_consumption,
            double recycling_amount, double carbon_reduction_rate) {
        this.userName = userName;
        this.location = location;
        this.water_consumption = water_consumption;
        this.electricity_consumption = electricity_consumption;
        this.recycling_amount = recycling_amount;
        this.carbon_reduction_rate = carbon_reduction_rate;
    }


    public void assign(WinnerDAO winner) {
        this.userName = winner.userName;
        this.location = winner.location;
        this.water_consumption = winner.water_consumption;
        this.electricity_consumption = winner.electricity_consumption;
        this.recycling_amount = winner.recycling_amount;
        this.carbon_reduction_rate = winner.carbon_reduction_rate;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWater_consumption(double water_consumption) {
        this.water_consumption = water_consumption;
    }

    public void setElectricity_consumption(double electricity_consumption) {
        this.electricity_consumption = electricity_consumption;
    }

    public void setRecycling_amount(double recycling_amount) {
        this.recycling_amount = recycling_amount;
    }

    public void setCarbon_reduction_rate(double carbon_reduction_rate) {
        this.carbon_reduction_rate = carbon_reduction_rate;
    }

    public String getUserName() {
        return userName;
    }

    public String getLocation() {
        return location;
    }

    public double getWater_consumption() {
        return water_consumption;
    }

    public double getElectricity_consumption() {
        return electricity_consumption;
    }

    public double getRecycling_amount() {
        return recycling_amount;
    }

    public double getCarbon_reduction_rate() {
        return carbon_reduction_rate;
    }


    // methods to faciliate DTO
    public void fromDTO(final WinnerDTO dto) {
        this.userName = dto.getUserName();
        this.location = dto.getLocation();
        this.water_consumption = dto.getWater_consumption();
        this.electricity_consumption = dto.getElectricity_consumption();
        this.recycling_amount = dto.getRecycling_amount();
        this.carbon_reduction_rate = dto.getCarbon_reduction_rate();

    }

    public WinnerDTO toDTO() {
        WinnerDTO dto = new WinnerDTO();
        dto.setUserName(this.userName);
        dto.setLocation(this.location);
        dto.setWater_consumption(this.water_consumption);
        dto.setElectricity_consumption(this.electricity_consumption);
        dto.setRecycling_amount(this.recycling_amount);
        dto.setCarbon_reduction_rate(this.carbon_reduction_rate);

        return dto;
    }

    public WinnerDAO(final WinnerDTO dto){
        this.fromDTO(dto);
    }

   // methods to faciliate debugging

    @Override
    public String toString() {
        return "Winner [userName=" + userName + ", location=" + location + ", water consumption=" + water_consumption + ", electricity consumption=" + electricity_consumption
                + ", recycling amount=" + recycling_amount + ", carbon reduction rate=" + carbon_reduction_rate + "]";
    }


}
