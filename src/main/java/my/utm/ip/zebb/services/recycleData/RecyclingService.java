package my.utm.ip.zebb.services.recycleData;

import java.util.*;
import my.utm.ip.zebb.models.recycleData.RecyclingDAO;

public interface RecyclingService{
    
    List<RecyclingDAO> getAllRecycleData();
    RecyclingDAO addRecycleData1(final RecyclingDAO recycle);
    RecyclingDAO addRecycleData2(final RecyclingDAO recycle);
    RecyclingDAO getRecycleDataByUserName_month(String userName, String month);
    // RecyclingDAO updateRecycleData(final RecyclingDAO recycle);
    // public boolean deleteRecycleData(String userName, String month);
}
