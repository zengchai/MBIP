package my.utm.ip.zebb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.utm.ip.zebb.models.winner.WinnerDAO;
import my.utm.ip.zebb.models.winner.WinnerDTO;
import my.utm.ip.zebb.services.winner.WinnerService;

@Controller
@RequestMapping("/winner")

public class WinnerController {

    @Autowired
    private WinnerService winnerService;

    @RequestMapping("/listAllWinner")
    public String home(Model model) {

        List<WinnerDAO> winner = winnerService.getAllWinners();
        model.addAttribute("winner", winner);

        return "winner/competitionUser";

    }

    @RequestMapping("/selectFromWinnerList")   //model must have same name with sql database attribute
    public String selectFromWinnerList(Model model) {

        List<WinnerDAO> winners = winnerService.getWinnersByUserAndMonth();
        model.addAttribute("winners", winners);

        return "winner/pertandinganadmin2"; //need change
    }

    @RequestMapping("/updateWinner")
    public String updateWinner(
            @RequestParam("username") String userName,
            @RequestParam("month") String month) {
        
        WinnerDAO winner = new WinnerDAO();
        winner.setUserName(userName);
        winner.setMonth(month);

        try {
            winnerService.updateWinner(winner);
            System.out.println("Update successful");
            return "winner/pertandinganadmin"; // Redirect on successful update
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // You can add error handling here, like showing an error message to the user
            return "errorPage"; // Return an error page or another appropriate view
        }
    }


    // @RequestMapping("/viewAddWinnerForm")

    // public String addWinnerForm(Model model) {

    //     model.addAttribute("mode", "add");
    //     model.addAttribute("winner", new WinnerDAO());

    //     return "product/formProduct"; //need change

    // }

    // @RequestMapping("/viewEditWinnerForm")

    // public String editWinnerForm(@RequestParam String userName, Model model) {
    //     WinnerDAO winner = winnerService.getWinnerByUserName(userName);
    //     model.addAttribute("winner", winner);
    //     model.addAttribute("mode", "edit");

    //     return "product/formProduct"; //need change

    // }

    // @RequestMapping("/addWinner")

    // public String addWinner(
    //         @RequestParam("userName") String userName,
    //         @RequestParam("location") String location,
    //         @RequestParam("water_consumption") String swater_comsumption,
    //         @RequestParam("electricity_consumption") String selectricity_consumption,
    //         @RequestParam("recycling_amount") String srecycling_amount,
    //         @RequestParam("carbon_reduction_rate") String scarbon_reduction_rate) {
    //     double water_consumption = Double.parseDouble(swater_comsumption);
    //     double electricity_consumption = Double.parseDouble(selectricity_consumption);
    //     double recycling_amount = Double.parseDouble(srecycling_amount);
    //     double carbon_reduction_rate = Double.parseDouble(scarbon_reduction_rate);
    //     WinnerDAO winner = new WinnerDAO(userName, location, water_consumption, electricity_consumption, recycling_amount, carbon_reduction_rate);
    //     winnerService.addWinner(winner);

    //     return "redirect:competitionUser"; //need change
    // }

    // @RequestMapping("/editProduct")

    // public String editProduct(
    //         @RequestParam("userName") String userName,
    //         @RequestParam("location") String location,
    //         @RequestParam("water_consumption") String swater_comsumption,
    //         @RequestParam("electricity_consumption") String selectricity_consumption,
    //         @RequestParam("recycling_amount") String srecycling_amount,
    //         @RequestParam("carbon_reduction_rate") String scarbon_reduction_rate) {
    //     double water_consumption = Double.parseDouble(swater_comsumption);
    //     double electricity_consumption = Double.parseDouble(selectricity_consumption);
    //     double recycling_amount = Double.parseDouble(srecycling_amount);
    //     double carbon_reduction_rate = Double.parseDouble(scarbon_reduction_rate);
    //     WinnerDAO winner = new WinnerDAO(userName, location, water_consumption, electricity_consumption, recycling_amount, carbon_reduction_rate);
    //     winnerService.updateWinner(winner);

    //     return "redirect:competitionUser"; //need change
    // }

    // @RequestMapping("/deleteWinner")

    // public String deleteWinner(@RequestParam String userName, Model model) {

    //     boolean success = winnerService.deleteWinner(userName);

    //     if (success) {

    //         return "redirect:competitionUser"; //need change
    //     }

    //     model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
    //     return "/product/error"; //need change or delete

    // }

}
