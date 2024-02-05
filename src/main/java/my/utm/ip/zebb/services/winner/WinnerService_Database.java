package my.utm.ip.zebb.services.winner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.zebb.models.winner.Winner;
import my.utm.ip.zebb.models.winner.WinnerDAO;
import my.utm.ip.zebb.models.winner.Repository.WinnerRepository;

public class WinnerService_Database implements WinnerService {
    
    @Autowired
    WinnerRepository repo;

    @Override
    public List<Winner> getWinnersByUserAndMonth() {
        List<WinnerDAO> daos = repo.getWinnersByUserAndMonth();
        List<Winner> winners = new ArrayList<>();

        for (WinnerDAO dao : daos) {
            Winner winner = new Winner(dao);

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
    public Winner updateWinner(Winner winner) {
        WinnerDAO dao = repo.updateWinner(winner.toDAO()); //setto
        return new Winner(dao); //
    }

    @Override
    public int getWinnerCountForMonth(String month) {
    
        return repo.getWinnerCountForMonth(month);
    }

    @Override
    public List<Winner> getWinners() {
        List<WinnerDAO> daos = repo.getWinners();
        List<Winner> winners = new ArrayList<>();

        for (WinnerDAO dao : daos) {
            Winner winner = new Winner(dao);

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
    public boolean deleteWinnerByUsername(String userName) {
        boolean success = repo.deleteWinnerByUsername(userName);

        return success;
    }

    
}
