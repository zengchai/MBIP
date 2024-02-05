package my.utm.ip.zebb.models.winner.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.zebb.models.winner.WinnerDAO;

@Repository
public interface WinnerRepository {
   
    List<WinnerDAO> getWinnersByUserAndMonth();
    WinnerDAO updateWinner(final WinnerDAO recycle);
    int getWinnerCountForMonth(String month);
    List<WinnerDAO> getWinners();
    boolean deleteWinnerByUsername(String userName);

}    



