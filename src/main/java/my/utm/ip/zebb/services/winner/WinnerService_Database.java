package my.utm.ip.zebb.services.winner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.winner.WinnerDAO;
import my.utm.ip.zebb.models.winner.WinnerDTO;
import my.utm.ip.zebb.models.winner.WinnerRepository;

public class WinnerService_Database implements WinnerService {
    
    @Autowired
    WinnerRepository repo;

    @Override
    public List<WinnerDAO> getWinnersByUserAndMonth() {
        List<WinnerDTO> dtos = repo.getWinnersByUserAndMonth();
        List<WinnerDAO> winners = new ArrayList<>();

        for (WinnerDTO dto : dtos) {
            WinnerDAO winner = new WinnerDAO(dto);

            // Calculate the carbon_reduction_rate
            double sumCarbonFactors = winner.getRecycling_carbon_factor() +
                                    winner.getElectric_carbon_factor() +
                                    winner.getWater_carbon_factor();
            double carbonReductionRate = sumCarbonFactors / 3.0;

            // Set the carbon_reduction_rate in the WinnerDAO object
            winner.setCarbon_reduction_rate(carbonReductionRate);

            winners.add(winner);
        }

        return winners;
    }

    @Override
    public WinnerDAO updateWinner(WinnerDAO winner) {
        WinnerDTO dto = repo.updateWinner(winner.toDTO()); //setto
        return new WinnerDAO(dto); //
    }

    @Override
    public int getWinnerCountForMonth(String month) {
    
        return repo.getWinnerCountForMonth(month);
    }

    @Override
    public List<WinnerDAO> getWinners() {
        List<WinnerDTO> dtos = repo.getWinners();
        List<WinnerDAO> winners = new ArrayList<>();

        for (WinnerDTO dto : dtos) {
            WinnerDAO winner = new WinnerDAO(dto);

            // Calculate the carbon_reduction_rate
            double sumCarbonFactors = winner.getRecycling_carbon_factor() +
                                    winner.getElectric_carbon_factor() +
                                    winner.getWater_carbon_factor();
            double carbonReductionRate = sumCarbonFactors / 3.0;

            // Set the carbon_reduction_rate in the WinnerDAO object
            winner.setCarbon_reduction_rate(carbonReductionRate);

            winners.add(winner);
        }

        return winners;
    }

    
}
