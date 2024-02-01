package my.utm.ip.zebb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.services.user.UserService;
@Controller
@RequestMapping("/")

public class TimeLineController {

    @Autowired
    private UserService userService;

    @RequestMapping("/timeline")
    public String timeline(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "password",required = false) String password,
                        @RequestParam(value = "error",required = false) String olderror,
                        HttpSession session,Model model){
        User currentUser = userService.login(username);
        String error = "Your username or password is incorrect";
        if(currentUser.getId()!=0){

        if(currentUser.getPassword().equals(password)){

            currentUser.setAuthenticated(true);
            session.setAttribute("user", currentUser);
        }else{
            if (olderror == null) {
                model.addAttribute("error", error);
            }
            currentUser.setAuthenticated(false);

        }       

        }
        else{
            if (olderror == null) {
            model.addAttribute("error", error);
            }
        }

        return "main/index";  //need change

    }

}
