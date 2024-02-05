package my.utm.ip.zebb.models.waterData.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.waterData.Water;
import my.utm.ip.zebb.models.waterData.WaterDAO;

@Repository
public interface WaterRepository {
   List<WaterDAO> getAllWaterData();
    WaterDAO addWaterData(final WaterDAO water);
    List<WaterDAO> getWaterDataByUserName(String userName);
    WaterDAO updateWaterData(final WaterDAO water);
    public boolean deleteWaterData(String month);
    List<Water> getWaterDataByMonth(String month);
    
    
} 