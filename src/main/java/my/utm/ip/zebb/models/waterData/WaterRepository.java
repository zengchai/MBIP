package my.utm.ip.zebb.models.waterData;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.waterData.Repository.WaterDAO;
import my.utm.ip.zebb.models.waterData.Repository.WaterDTO;

@Repository
public interface WaterRepository {
   List<WaterDTO> getAllWaterData();
    WaterDTO addWaterData(final WaterDTO water);
    List<WaterDTO> getWaterDataByUserName(String userName);
    WaterDTO updateWaterData(final WaterDTO water);
    public boolean deleteWaterData(String month);
    List<WaterDAO> getWaterDataByMonth(String month);
    
    
} 