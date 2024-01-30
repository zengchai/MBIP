package my.utm.ip.zebb.models.waterData;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface WaterRepository {
   
    List<WaterDTO> getAllWaterData();
    WaterDTO addWaterData1(final WaterDTO water);
    WaterDTO addWaterData2(final WaterDTO water);
    WaterDTO getWaterDataByUserName_month(String userName, String month);
    
} 