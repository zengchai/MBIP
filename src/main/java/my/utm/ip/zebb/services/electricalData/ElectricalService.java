package my.utm.ip.zebb.services.electricalData;

import java.util.*;

import my.utm.ip.zebb.models.electricalData.Electrical;

public interface ElectricalService {

    List<Electrical> getAllElectricalData();

    Electrical addElectricalData(final Electrical electrical);

    List<Electrical> getElectricalDataByUserName(String userName);

    Electrical updateElectricalData(final Electrical recycle);

    public boolean deleteElectricalData(String month);

    double getAllConsumption();

}
