package my.utm.ip.zebb.services.winner;

import java.util.*;
import my.utm.ip.zebb.models.winner.WinnerDAO;

public interface WinnerService{
    
    List<WinnerDAO> getWinnersByUserAndMonth();
    WinnerDAO updateWinner(final WinnerDAO winner);
    int getWinnerCountForMonth(String month);
    List<WinnerDAO> getWinners();

}
