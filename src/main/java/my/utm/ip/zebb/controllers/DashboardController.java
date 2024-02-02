package my.utm.ip.zebb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.utm.ip.zebb.services.electricalData.ElectricalService;
import my.utm.ip.zebb.services.recycleData.RecyclingService;
import my.utm.ip.zebb.services.user.UserService;
import my.utm.ip.zebb.services.waterData.WaterService;

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
        
    public String dashbaord(HttpSession session,Model model){
        
        int usernum = userService.getAllUserNum();
        double elecnum = electricalService.getAllConsumption();
        double recyclingnum = recyclingService.getAllConsumption();
        double waternum = waterService.getAllConsumption();
        double carbonreduction = (elecnum+recyclingnum+waternum)/3;
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
