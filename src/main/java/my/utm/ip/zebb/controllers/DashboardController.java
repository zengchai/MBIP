package my.utm.ip.zebb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import my.utm.ip.zebb.services.electricalData.ElectricalService;
import my.utm.ip.zebb.services.recycleData.RecyclingService;
import my.utm.ip.zebb.services.user.UserService;
import my.utm.ip.zebb.services.waterData.WaterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DashboardController {

    @Autowired
    private ElectricalService electricalService;

    @Autowired
    private RecyclingService recyclingService;

    @Autowired
    private WaterService waterService;

    @Autowired
    private UserService userService;

    @RequestMapping("dashboard")
    public String dashbaord(HttpSession session, Model model) {

        int usernum = userService.getAllUserNum();
        double elecnum = electricalService.getAllConsumption();
        double recyclingnum = recyclingService.getAllConsumption();
        double waternum = waterService.getAllConsumption();
        double carbonreduction = (elecnum*0.548 + recyclingnum*2.860 + waternum*0.419) / 3;
        String formattedElecNum = String.format("%.2f", elecnum);
        String formattedRecyclingNum = String.format("%.2f", recyclingnum);
        String formattedWaterNum = String.format("%.2f", waternum);
        String formattedcarbonreduction = String.format("%.2f", carbonreduction);
        model.addAttribute("usernum", usernum);
        model.addAttribute("elecnum", formattedElecNum);
        model.addAttribute("recyclingnum", formattedRecyclingNum);
        model.addAttribute("waternum", formattedWaterNum);
        model.addAttribute("carbonreduction", formattedcarbonreduction);
        return "staff/dashboard";
    }

    
}
