package my.utm.ip.zebb.services.winner;

import java.util.*;
import my.utm.ip.zebb.models.winner.WinnerDAO;

public interface WinnerService{
    
    List<WinnerDAO> getAllWinners();
    List<WinnerDAO> getWinnersByUserAndMonth();
    WinnerDAO updateWinner(final WinnerDAO winner);
    //WinnerDAO updateWinner(final WinnerDAO winner);
    public boolean deleteWinner(String winner);
}
