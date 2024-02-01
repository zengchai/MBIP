package my.utm.ip.zebb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.services.user.UserService;

@Controller
@RequestMapping("/")

public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/loginvalidation")
    public String loginvalidation(@RequestParam(value = "username",required = false) String username,
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

        return "redirect:/winner/listAllWinner";  //need change

    }


    @RequestMapping("/register")
    public String register(){
        return "main/registration";
    }

    @RequestMapping("/registervalidation")
    public String register(@RequestParam("username") String username,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session){
        User newUser = new User(username,email,password);
        userService.register(newUser);

        session.setAttribute("user", newUser);

        return "redirect:/winner/listAllWinner";  //need change

    }

    @RequestMapping("/updateprofile")
    public String updateProfile(
            @RequestParam("fullname") String fullname,
            @RequestParam("nickname") String nickname,
            @RequestParam("email") String email,
            @RequestParam("phonenum") String phonenum,
            @RequestParam("language") String language,
            @RequestParam("category") String category,
            @RequestParam("poscode") String poscode,
            @RequestParam("address") String address,
            HttpSession session
    ){
        User curuser = (User) session.getAttribute("user");
        curuser.setFullname(fullname);
        curuser.setNickname(nickname);
        curuser.setEmail(email);
        curuser.setPhoneNum(phonenum);
        curuser.setPreferredLanguage(language);
        curuser.setCategory(category);
        curuser.setPoscode(poscode);
        curuser.setAddress(address);
        userService.updateProfile(curuser);
        
        session.removeAttribute("user");
        
        session.setAttribute("user",curuser);
        return "redirect:editprofile";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "main/index";
    }


    @RequestMapping("/editprofile")
    public String editprofile(){
        return "user/editprofile";
    }
}
