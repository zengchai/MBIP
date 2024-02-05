package my.utm.ip.zebb.services.recycleData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.recycleData.Recycling;
import my.utm.ip.zebb.models.recycleData.RecyclingDAO;
import my.utm.ip.zebb.models.recycleData.Repository.RecyclingRepository;
public class RecyclingService_Database implements RecyclingService {

    @Autowired
    RecyclingRepository repo;

    @Override
    public List<Recycling> getAllRecycleData() {
        List<RecyclingDAO> daos = repo.getAllRecycleData();
        List<Recycling> recycle = new ArrayList<Recycling>();
        for (RecyclingDAO dao : daos) {
            recycle.add(new Recycling(dao));
        }
        return recycle;
    }

    @Override
    public Recycling addRecycleData(Recycling recycle) {
        RecyclingDAO dao = repo.addRecycleData(recycle.toDAO()); // setto
        return new Recycling(dao); //
    }

    @Override
    public List<Recycling> getRecycleDataByUserName(String userName) {
        List<RecyclingDAO> daos = repo.getRecycleDataByUserName(userName);
        List<Recycling> recycle = new ArrayList<Recycling>();

        for (RecyclingDAO dao : daos) {
            recycle.add(new Recycling(dao));
        }

        return recycle;
    }

    @Override
    public Recycling updateRecycleData(Recycling recycle) {
        RecyclingDAO dao = repo.updateRecycleData(recycle.toDAO()); // setto
        return new Recycling(dao);
    }

    @Override
    public boolean deleteRecycleData(String month) {
        boolean success = repo.deleteRecycleData(month);
        return success;

    }

    @Override
    public double getAllConsumption() {
        List<Recycling> recyclingList = this.getAllRecycleData();
        Double consumption = 0.0;
        for (int i = 0; i < recyclingList.size(); i++) {
            consumption += recyclingList.get(i).getWeight();
        }
        consumption = consumption / recyclingList.size();
        return consumption;
    }
}
