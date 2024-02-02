package my.utm.ip.zebb.models.winner;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository {
   
    List<WinnerDTO> getWinnersByUserAndMonth();
    WinnerDTO updateWinner(final WinnerDTO recycle);
    int getWinnerCountForMonth(String month);
    List<WinnerDTO> getWinners();

}    



