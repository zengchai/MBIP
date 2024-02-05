package my.utm.ip.zebb.services.recycleData;

import java.util.*;

import my.utm.ip.zebb.models.recycleData.Recycling;

public interface RecyclingService {

    List<Recycling> getAllRecycleData();

    Recycling addRecycleData(final Recycling recycle);

    List<Recycling> getRecycleDataByUserName(String userName);

    Recycling updateRecycleData(final Recycling recycle);

    public boolean deleteRecycleData(String month);

    double getAllConsumption();
}
