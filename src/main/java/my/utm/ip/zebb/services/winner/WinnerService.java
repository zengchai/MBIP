package my.utm.ip.zebb.services.winner;

import java.util.*;
import my.utm.ip.zebb.models.winner.Winner;

public interface WinnerService{
    
    List<Winner> getWinnersByUserAndMonth();
    Winner updateWinner(final Winner winner);
    int getWinnerCountForMonth(String month);
    boolean deleteWinnerByUsername(String userName);
    List<Winner> getWinners();

}
