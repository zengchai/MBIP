package my.utm.ip.zebb.models.electricalData.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;

@Repository
public interface ElectricalRepository {
   
    List<ElectricalDAO> getAllElectricalData();
    ElectricalDAO addElectricalData(final ElectricalDAO electrical);
    List<ElectricalDAO> getElectricalDataByUserName(String userName);
    ElectricalDAO updateElectricalData(final ElectricalDAO electrical);
    public boolean deleteElectricalData(String month);
} 