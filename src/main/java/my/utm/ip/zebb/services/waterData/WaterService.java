package my.utm.ip.zebb.services.waterData;

import java.util.*;

import my.utm.ip.zebb.models.waterData.WaterDAO;

public interface WaterService{
    
    List<WaterDAO> getAllWaterData();
    WaterDAO addWaterData1(final WaterDAO water);
    WaterDAO addWaterData2(final WaterDAO water);
    WaterDAO getWaterDataByUserName_month(String userName, String month);
    double getAllConsumption();
}