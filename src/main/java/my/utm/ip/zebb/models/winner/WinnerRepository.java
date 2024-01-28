package my.utm.ip.zebb.models.winner;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository {
   
    List<WinnerDTO> getAllWinners();
    WinnerDTO addWinner(final WinnerDTO recycle);
    WinnerDTO getWinnerByUserName(String userName);
    WinnerDTO updateWinner(final WinnerDTO winner);
    public boolean deleteWinner(String winner);
}    



