package my.utm.ip.zebb.services.electricalData;

import java.util.*;

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;

public interface ElectricalService{
    
    List<ElectricalDAO> getAllElectricalData();
    ElectricalDAO addElectricalData1(final ElectricalDAO electrical);
    ElectricalDAO addElectricalData2(final ElectricalDAO electrical);
    ElectricalDAO getElectricalDataByUserName_month(String userName, String month);
    double getAllConsumption();
}