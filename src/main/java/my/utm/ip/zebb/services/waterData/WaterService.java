package my.utm.ip.zebb.services.waterData;

import java.util.*;

import my.utm.ip.zebb.models.waterData.WaterDAO;

public interface WaterService{
    
    
    List<WaterDAO> getAllWaterData();
    WaterDAO addWaterData(final WaterDAO electrical);
    List<WaterDAO> getWaterDataByUserName(String userName);
    WaterDAO updateWaterData(final WaterDAO recycle);
    public boolean deleteWaterData(String month);

}