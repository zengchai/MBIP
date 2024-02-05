package my.utm.ip.zebb.services.winner;

import java.util.*;
import my.utm.ip.zebb.models.winner.Winner;

public interface WinnerService{
    
    List<Winner> getWinnersByUserAndMonth();
    Winner updateWinner(final Winner winner);
    int getWinnerCountForMonth(String month);
<<<<<<< HEAD
    List<WinnerDAO> getWinners();
    boolean deleteWinnerByUsername(String userName);
=======
    List<Winner> getWinners();
>>>>>>> b11b206c0465b497d9f2c53f2c108826a8d8912c

}
