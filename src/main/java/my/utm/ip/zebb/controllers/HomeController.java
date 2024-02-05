package my.utm.ip.zebb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/","/home", "/index"})
    public String home() {
        return "main/index";
    }

    @RequestMapping("/BillPage")
    public String bill(){
        return "main/BillPage";
    }

}
