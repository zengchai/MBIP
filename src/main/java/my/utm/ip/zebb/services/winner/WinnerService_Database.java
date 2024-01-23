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
    public List<WinnerDAO> getAllWinners() {
        List<WinnerDTO> dtos = repo.getAllWinners();
        List<WinnerDAO> winner = new ArrayList<WinnerDAO>();
        for (WinnerDTO dto:dtos){
            winner.add(new WinnerDAO(dto));
        }
        return winner;
    }

    @Override
    public WinnerDAO addWinner(WinnerDAO winner) {
        WinnerDTO dto = repo.addWinner(winner.toDTO()); //setto
        return new WinnerDAO(dto); //
    }

    @Override
    public WinnerDAO getWinnerByUserName(String userName) {
        WinnerDTO dto =repo.getWinnerByUserName(userName);
        WinnerDAO winner= new WinnerDAO();
        winner.fromDTO(dto); //getto

        return winner;
    }

    @Override
    public WinnerDAO updateWinner(WinnerDAO winner) {
        WinnerDTO dto = repo.updateWinner(winner.toDTO()); //setto
        return new WinnerDAO(dto);
    }

    @Override
    public boolean deleteWinner(String userName) {
        boolean success=repo.deleteWinner(userName);
        return success;

    }
    
}
