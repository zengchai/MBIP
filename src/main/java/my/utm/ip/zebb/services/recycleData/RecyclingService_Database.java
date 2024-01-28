package my.utm.ip.zebb.services.recycleData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.recycleData.RecyclingDAO;
import my.utm.ip.zebb.models.recycleData.RecyclingDTO;
import my.utm.ip.zebb.models.recycleData.RecyclingRepository;

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
    public RecyclingDAO getRecycleDataByUserName_month(String userName, String month) {
        RecyclingDTO dto =repo.getRecycleDataByUserName_month(userName, month);
        RecyclingDAO recycle= new RecyclingDAO();
        recycle.fromDTO(dto); //getto

        return recycle;
    }

    // @Override
    // public RecyclingDAO updateRecycleData(WinnerDAO winner) {
    //     WinnerDTO dto = repo.updateWinner(winner.toDTO()); //setto
    //     return new WinnerDAO(dto);
    // }

    // @Override
    // public boolean deleteRecycleData(String userName) {
    //     boolean success=repo.deleteWinner(userName);
    //     return success;

    // }
    
}
