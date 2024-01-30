package my.utm.ip.zebb.models.electricalData;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalRepository {
   
    List<ElectricalDTO> getAllElectricalData();
    ElectricalDTO addElectricalData1(final ElectricalDTO electrical);
    ElectricalDTO addElectricalData2(final ElectricalDTO electrical);
    ElectricalDTO getElectricalDataByUserName_month(String userName, String month);
    
} 