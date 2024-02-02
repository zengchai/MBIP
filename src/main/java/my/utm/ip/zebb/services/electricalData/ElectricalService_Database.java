package my.utm.ip.zebb.services.electricalData;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;
import my.utm.ip.zebb.models.electricalData.ElectricalDTO;
import my.utm.ip.zebb.models.electricalData.ElectricalRepository;
import my.utm.ip.zebb.models.waterData.WaterDAO;


public class ElectricalService_Database implements ElectricalService {
    
    @Autowired
    ElectricalRepository repo;

    @Override
    public List<ElectricalDAO> getAllElectricalData() {
        List<ElectricalDTO> dtos = repo.getAllElectricalData();
        List<ElectricalDAO> electrical = new ArrayList<ElectricalDAO>();
        for (ElectricalDTO dto:dtos){
            electrical.add(new ElectricalDAO(dto));
        }
        return electrical;
    }

    @Override
    public ElectricalDAO addElectricalData(ElectricalDAO electrical) {
        ElectricalDTO dto = repo.addElectricalData(electrical.toDTO()); //setto
        return new ElectricalDAO(dto); //
    }

    @Override
    public List<ElectricalDAO> getElectricalDataByUserName(String userName) {
        List<ElectricalDTO> dtos = repo.getElectricalDataByUserName(userName);
        List<ElectricalDAO> electrical = new ArrayList<ElectricalDAO>();

        for (ElectricalDTO dto : dtos) {
            electrical.add(new ElectricalDAO(dto));
        }

        return electrical;
    }

    @Override
    public ElectricalDAO updateElectricalData(ElectricalDAO electrical) {
        ElectricalDTO dto = repo.updateElectricalData(electrical.toDTO()); //setto
        return new ElectricalDAO(dto);
    }

    @Override
    public boolean deleteElectricalData(String month) {
        boolean success=repo.deleteElectricalData(month);
        return success;

    }
    @Override
    public double getAllConsumption(){
        List<ElectricalDAO> elecList = this.getAllElectricalData();
        Double consumption = 0.0;
        for (int i = 0;i<elecList.size();i++){
            consumption += elecList.get(i).getAmount();
        }
        consumption = consumption/elecList.size();
        return consumption;
    }
    
}
