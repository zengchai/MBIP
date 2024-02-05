package my.utm.ip.zebb.services.waterData;

import java.util.*;

import my.utm.ip.zebb.models.waterData.Water;

public interface WaterService {

    List<Water> getAllWaterData();

    Water addWaterData(final Water electrical);

    List<Water> getWaterDataByUserName(String userName);

    Water updateWaterData(final Water recycle);

    public boolean deleteWaterData(String month);

    double getAllConsumption();

}