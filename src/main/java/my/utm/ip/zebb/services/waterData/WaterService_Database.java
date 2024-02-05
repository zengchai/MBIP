package my.utm.ip.zebb.services.waterData;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.waterData.Water;
import my.utm.ip.zebb.models.waterData.WaterDAO;
import my.utm.ip.zebb.models.waterData.Repository.WaterRepository;

public class WaterService_Database implements WaterService {

    @Autowired
    WaterRepository repo;

    @Override
    public List<Water> getAllWaterData() {
        List<WaterDAO> daos = repo.getAllWaterData();
        List<Water> water = new ArrayList<Water>();
        for (WaterDAO dao : daos) {
            water.add(new Water(dao));
        }
        return water;
    }

    @Override
    public Water addWaterData(Water water) {
        WaterDAO dao = repo.addWaterData(water.toDAO()); // setto
        return new Water(dao); //
    }

    @Override
    public List<Water> getWaterDataByUserName(String userName) {
        List<WaterDAO> daos = repo.getWaterDataByUserName(userName);
        List<Water> water = new ArrayList<Water>();

        for (WaterDAO dao : daos) {
            water.add(new Water(dao));
        }

        return water;
    }

    @Override
    public Water updateWaterData(Water water) {
        WaterDAO dao = repo.updateWaterData(water.toDAO()); // setto
        return new Water(dao);
    }

    @Override
    public boolean deleteWaterData(String month) {
        boolean success = repo.deleteWaterData(month);
        return success;

    }

    public double getAllConsumption() {
        List<Water> waterList = this.getAllWaterData();
        Double consumption = 0.0;
        for (int i = 0; i < waterList.size(); i++) {
            consumption += waterList.get(i).getAmount();
        }
        consumption = consumption / waterList.size();
        return consumption;
    }
    
}
