package my.utm.ip.zebb.services.recycleData;

import java.util.*;
import my.utm.ip.zebb.models.recycleData.RecyclingDAO;

public interface RecyclingService{
    
    List<RecyclingDAO> getAllRecycleData();
    RecyclingDAO addRecycleData(final RecyclingDAO recycle);
    List<RecyclingDAO> getRecycleDataByUserName(String userName);
    RecyclingDAO updateRecycleData(final RecyclingDAO recycle);
    public boolean deleteRecycleData(String month);
}
