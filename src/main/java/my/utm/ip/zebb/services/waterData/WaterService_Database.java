package my.utm.ip.zebb.services.waterData;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.waterData.WaterDAO;
import my.utm.ip.zebb.models.waterData.WaterDTO;
import my.utm.ip.zebb.models.waterData.WaterRepository;

public class WaterService_Database implements WaterService {
    
    @Autowired
    WaterRepository repo;

    @Override
    public List<WaterDAO> getAllWaterData() {
        List<WaterDTO> dtos = repo.getAllWaterData();
        List<WaterDAO> water = new ArrayList<WaterDAO>();
        for (WaterDTO dto:dtos){
            water.add(new WaterDAO(dto));
        }
        return water;
    }

   @Override
    public WaterDAO addWaterData(WaterDAO water) {
        WaterDTO dto = repo.addWaterData(water.toDTO()); //setto
        return new WaterDAO(dto); //
    }

    @Override
    public List<WaterDAO> getWaterDataByUserName(String userName) {
        List<WaterDTO> dtos = repo.getWaterDataByUserName(userName);
        List<WaterDAO> water = new ArrayList<WaterDAO>();

        for (WaterDTO dto : dtos) {
            water.add(new WaterDAO(dto));
        }

        return water;
    }

    @Override
    public WaterDAO updateWaterData(WaterDAO water) {
        WaterDTO dto = repo.updateWaterData(water.toDTO()); //setto
        return new WaterDAO(dto);
    }

    @Override
    public boolean deleteWaterData(String month) {
        boolean success=repo.deleteWaterData(month);
        return success;

    }
    
    public double getAllConsumption(){
        List<WaterDAO> waterList = this.getAllWaterData();
        Double consumption = 0.0;
        for (int i = 0;i<waterList.size();i++){
            consumption += waterList.get(i).getAmount();
        }
        consumption = consumption/waterList.size();
        return consumption;
    }
}
