package my.utm.ip.zebb.services.electricalData;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;
import my.utm.ip.zebb.models.electricalData.ElectricalDTO;
import my.utm.ip.zebb.models.electricalData.ElectricalRepository;


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
    
}
