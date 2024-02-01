package my.utm.ip.zebb.services.recycleData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.recycleData.RecyclingDAO;
import my.utm.ip.zebb.models.recycleData.RecyclingDTO;
import my.utm.ip.zebb.models.recycleData.RecyclingRepository;
import my.utm.ip.zebb.models.waterData.WaterDAO;

public class RecyclingService_Database implements RecyclingService {
    
    @Autowired
    RecyclingRepository repo;

    @Override
    public List<RecyclingDAO> getAllRecycleData() {
        List<RecyclingDTO> dtos = repo.getAllRecycleData();
        List<RecyclingDAO> recycle = new ArrayList<RecyclingDAO>();
        for (RecyclingDTO dto:dtos){
            recycle.add(new RecyclingDAO(dto));
        }
        return recycle;
    }

    @Override
    public RecyclingDAO addRecycleData(RecyclingDAO recycle) {
        RecyclingDTO dto = repo.addRecycleData(recycle.toDTO()); //setto
        return new RecyclingDAO(dto); //
    }

    @Override
    public List<RecyclingDAO> getRecycleDataByUserName(String userName) {
        List<RecyclingDTO> dtos = repo.getRecycleDataByUserName(userName);
        List<RecyclingDAO> recycle = new ArrayList<RecyclingDAO>();

        for (RecyclingDTO dto : dtos) {
            recycle.add(new RecyclingDAO(dto));
        }

        return recycle;
    }

    @Override
    public RecyclingDAO updateRecycleData(RecyclingDAO recycle) {
        RecyclingDTO dto = repo.updateRecycleData(recycle.toDTO()); //setto
        return new RecyclingDAO(dto);
    }

    @Override
    public boolean deleteRecycleData(String month) {
        boolean success=repo.deleteRecycleData(month);
        return success;

    }
    
    @Override
    public double getAllConsumption(){
        List<RecyclingDAO> recyclingList = this.getAllRecycleData();
        Double consumption = 0.0;
        for (int i = 0;i<recyclingList.size();i++){
            consumption += recyclingList.get(i).getWeight();
        }
        consumption = consumption/recyclingList.size();
        return consumption;
    }
}
