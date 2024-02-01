package my.utm.ip.zebb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;
import my.utm.ip.zebb.models.waterData.WaterDAO;
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
        
    @RequestMapping("/dashboard")
    public String dashbaord(HttpSession session,Model model){

        int usernum = userService.getAllUserNum();
        double elecnum = electricalService.getAllConsumption();
        double recyclingnum = recyclingService.getAllConsumption();
        double waternum = waterService.getAllConsumption();
        session.setAttribute("usernum", usernum);
        model.addAttribute("usernum", usernum);
        model.addAttribute("elecnum", elecnum);
        model.addAttribute("recyclingnum", recyclingnum);
        model.addAttribute("waternum", waternum);
        return "staff/dashboard";
    }
}
