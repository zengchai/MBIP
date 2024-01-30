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
    public WaterDAO addWaterData1(WaterDAO water) {
        WaterDTO dto = repo.addWaterData1(water.toDTO()); //setto
        return new WaterDAO(dto); //
    }

    @Override
    public WaterDAO addWaterData2(WaterDAO water) {
        WaterDTO dto = repo.addWaterData2(water.toDTO2()); //setto
        return new WaterDAO(dto); //
    }
    
    @Override
    public WaterDAO getWaterDataByUserName_month(String userName, String month) {
        WaterDTO dto =repo.getWaterDataByUserName_month(userName, month);
        WaterDAO water= new WaterDAO();
        water.fromDTO(dto); //getto

        return water;
    }

}
