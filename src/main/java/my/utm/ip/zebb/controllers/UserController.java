package my.utm.ip.zebb.controllers;

import java.util.List;

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
        User currentUser = userService.getUserThruUsername(username);
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

        return "main/index";

    }


    @RequestMapping("/register")
    public String register(){
        return "main/registration";
    }

    @RequestMapping("/registervalidation")
    public String register(@RequestParam("username") String username,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session,Model model){

        List<User> userList = userService.getAllUser();
        Boolean register = true;
        String error = "Please Try register again";
        for(User user:userList){
            if(user.getEmail().equals(email)){
                error = "Email already in use";
                register = false;
            }
            else if(user.getUsername().equals(username)){
                error = "Username already in use";
                register = false;
            }
        }
        if(register){

        User newUser = new User(username,email,password);
        userService.setUser(newUser);
        session.setAttribute("user", newUser);
        }
        else{
            model.addAttribute("error", error);
            return "main/registration";
        }

        return "main/index";

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
            HttpSession session,Model model
    ){
        
        int usernum = userService.getAllUserNum();
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
        model.addAttribute("usernum", usernum);
        session.removeAttribute("user");
        
    System.out.println(usernum);
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
