package my.utm.ip.zebb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/","/home", "/index"})
    public String home() {
        return "main/index";
    }

    
    @RequestMapping("/electricity")
    public String electricity() {
        return "ElectricityConsumption";
    }

    @RequestMapping("/recycling") //no used
    public String recycling() {
        return "RecyclingActivity";
    }

    @RequestMapping("/water")
    public String water() {
        return "WaterConsumption";
    }

    @RequestMapping("/electricitybill")
    public String electricitybill() {
        return "UploadElectricity";
    }

    @RequestMapping("/recyclingbill") // got user in RecyclingController
    public String recyclingbill() {
        return "UploadRecycling";
    }

    @RequestMapping("/waterbill")
    public String waterbill() {
        return "UploadWater";
    }
    @RequestMapping("/pertandinganadmin")
    public String pertandinganadmin(){
        return "pertandinganadmin";
    }
    @RequestMapping("/pertandinganadmin2")
    public String pertandinganadmiin2(){
        return "pertandinganadmin2";
    }
        @RequestMapping("/reportcalculation")
    public String reportcalculation(){
        return "reportcalculation";
    }
        @RequestMapping("/reportviewanalysis")
    public String reportviewanalysis(){
        return "reportviewanalysis";
    }
        @RequestMapping("/timeline")
    public String timeline(){
        return "timeline";
    }
        @RequestMapping("/timelineAdmin")
    public String timelineAdmin(){
        return "timelineAdmin";
    }

    @RequestMapping("/competitionUser") //not used
    public String competitionuser(){
        return "competitionUser";
    }

    @RequestMapping("/certificate")
    public String certificate(){
        return "certificate";
    }

    @RequestMapping("/BillPage")
    public String bill(){
        return "BillPage";
    }
}
