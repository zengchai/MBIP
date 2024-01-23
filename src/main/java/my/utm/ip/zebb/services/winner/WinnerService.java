package my.utm.ip.zebb.services.winner;

import java.util.*;
import my.utm.ip.zebb.models.winner.WinnerDAO;

public interface WinnerService{
    
    List<WinnerDAO> getAllWinners();
    WinnerDAO addWinner(final WinnerDAO winner);
    WinnerDAO getWinnerByUserName(String userName);
    WinnerDAO updateWinner(final WinnerDAO winner);
    public boolean deleteWinner(String winner);
}
