package my.utm.ip.zebb.models.recycleData.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.recycleData.RecyclingDAO;

@Repository
public interface RecyclingRepository {
   
    List<RecyclingDAO> getAllRecycleData();
    RecyclingDAO addRecycleData(final RecyclingDAO recycle);
    List<RecyclingDAO> getRecycleDataByUserName(String userName);
    RecyclingDAO updateRecycleData(final RecyclingDAO recycle);
    public boolean deleteRecycleData(String month);
}    



