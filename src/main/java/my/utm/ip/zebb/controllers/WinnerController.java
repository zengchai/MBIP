package my.utm.ip.zebb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.utm.ip.zebb.models.winner.WinnerDAO;
import my.utm.ip.zebb.services.winner.WinnerService;

@Controller
@RequestMapping("/winner")

public class WinnerController {

    @Autowired
    private WinnerService winnerService;

    @RequestMapping("/selectFromWinnerList")   //model must have same name with sql database attribute
    public String selectFromWinnerList(Model model) {

        List<WinnerDAO> winners = winnerService.getWinnersByUserAndMonth();
        model.addAttribute("winners", winners);

        return "winner/pertandinganadmin2"; //need change
    }

    @RequestMapping("/updateWinners")
    public String updateWinners(@RequestParam("selectedUserAndMonth") List<String> selectedUserAndMonths) {
        try {
            // Validate the number of selected winners (up to 3)
            if (selectedUserAndMonths.size() > 3) {
                // Handle the case where more than 3 winners are selected
                // You can add error handling here, like showing an error message to the user
                return "redirect:/winner/updateWinners"; //need change 
            }
    
            // Iterate through the selected winners and update the 'Winner' column
            for (String selectedUserAndMonth : selectedUserAndMonths) {
                String[] parts = selectedUserAndMonth.split("_");
                String username = parts[0];
                String month = parts[1];

                 // Check if there are already 3 winners for the selected month
                int winnerCountForMonth = winnerService.getWinnerCountForMonth(month);
                if (winnerCountForMonth >= 3) {
                    // Handle the case where there are already 3 winners for the selected month
                    // You can add error handling here, like showing an error message to the user
                    return "redirect:/winner/updateWinners"; //need change 
                }

    
                WinnerDAO winner = new WinnerDAO();
                winner.setUserName(username);
                winner.setMonth(month);
                winnerService.updateWinner(winner);
    
                System.out.println("Update successful for " + username + " in month " + month);
            }
    
            return "redirect:/winner/finalWinners"; //need change // Redirect on successful update

        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // You can add error handling here, like showing an error message to the user
            return "redirect:/winner/updateWinners"; //need change 
        }
    }

    @RequestMapping("/finalWinners")   //model must have same name with sql database attribute
    public String showWinner(Model model) {

        List<WinnerDAO> finalWinners = winnerService.getWinners();
        model.addAttribute("finalWinners", finalWinners);

        return "winner/pertandinganadmin"; //need change
    }

    @RequestMapping("/finalWinnersUser")   //model must have same name with sql database attribute
    public String showWinnerUser(Model model) {

        List<WinnerDAO> finalWinners = winnerService.getWinners();
        model.addAttribute("finalWinners", finalWinners);

        return "winner/pertandinganUser"; //need change
    }


    
}
