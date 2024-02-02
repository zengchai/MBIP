package my.utm.ip.zebb.services.electricalData;

import java.util.*;

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;

public interface ElectricalService{
    
    List<ElectricalDAO> getAllElectricalData();
    ElectricalDAO addElectricalData(final ElectricalDAO electrical);
    List<ElectricalDAO> getElectricalDataByUserName(String userName);
    ElectricalDAO updateElectricalData(final ElectricalDAO recycle);
    public boolean deleteElectricalData(String month);

}
   