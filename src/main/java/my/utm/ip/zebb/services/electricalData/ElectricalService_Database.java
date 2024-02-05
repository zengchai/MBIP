package my.utm.ip.zebb.services.electricalData;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.electricalData.Electrical;
import my.utm.ip.zebb.models.electricalData.ElectricalDAO;
import my.utm.ip.zebb.models.electricalData.Repository.ElectricalRepository;

public class ElectricalService_Database implements ElectricalService {
    
    @Autowired
    ElectricalRepository repo;

    @Override
    public List<Electrical> getAllElectricalData() {
        List<ElectricalDAO> daos = repo.getAllElectricalData();
        List<Electrical> electrical = new ArrayList<Electrical>();
        for (ElectricalDAO dao:daos){
            electrical.add(new Electrical(dao));
        }
        return electrical;
    }

    @Override
    public Electrical addElectricalData(Electrical electrical) {
        ElectricalDAO dao = repo.addElectricalData(electrical.toDAO()); //setto
        return new Electrical(dao); //
    }

    @Override
    public List<Electrical> getElectricalDataByUserName(String userName) {
        List<ElectricalDAO> daos = repo.getElectricalDataByUserName(userName);
        List<Electrical> electrical = new ArrayList<Electrical>();

        for (ElectricalDAO dao : daos) {
            electrical.add(new Electrical(dao));
        }

        return electrical;
    }

    @Override
    public Electrical updateElectricalData(Electrical electrical) {
        ElectricalDAO dao = repo.updateElectricalData(electrical.toDAO()); //setto
        return new Electrical(dao);
    }

    @Override
    public boolean deleteElectricalData(String month) {
        boolean success=repo.deleteElectricalData(month);
        return success;

    }
    @Override
    public double getAllConsumption(){
        List<Electrical> elecList = this.getAllElectricalData();
        Double consumption = 0.0;
        for (int i = 0;i<elecList.size();i++){
            consumption += elecList.get(i).getAmount();
        }
        consumption = consumption/elecList.size();
        return consumption;
    }
    
    
}
