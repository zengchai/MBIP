package my.utm.ip.zebb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.utm.ip.zebb.models.timeline.Timeline;
import my.utm.ip.zebb.services.timeline.TimelineService;
@Controller
@RequestMapping("/")

public class TimeLineController {

    @Autowired
    private TimelineService timelineservice;

    @RequestMapping("/viewTimeLine")
    public ModelAndView View(){
        List<Timeline> timelines= timelineservice.getAlltimeline();
         ModelAndView modelAndView = new ModelAndView("timeline/timeline");
        modelAndView.addObject("timeline", timelines);
        return modelAndView;
    }

    @RequestMapping("/viewTimeLineAdmin")
    public ModelAndView AdminView(){
        List<Timeline> timelines= timelineservice.getAlltimeline();
         ModelAndView modelAndView = new ModelAndView("timeline/timelineAdmin");
        modelAndView.addObject("timeline", timelines);
        return modelAndView;
    }

    @RequestMapping("/addNewEvent")
    public String addNewEvent(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("month") String month,
            Model model) {

        // Set the attributes in the model (if needed)
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("month", month);

        // Save the new event to the database
        Timeline newEvent = new Timeline(month, title, description);
        timelineservice.addNewEvent(newEvent);
        System.out.println("Attempting to save new event: " + newEvent);

        // Redirect to viewTimeLine
        return "redirect:/viewTimeLine";
    }

    @RequestMapping("/viewUpdataEventForm")
    public String viewUpdataEventForm(
        @RequestParam("id") int id,
        @RequestParam("description") String description,
        @RequestParam("month") String month,
        HttpSession session) {

        session.setAttribute("id", id);

        return "timeline/editevent";
    }

    @RequestMapping("/updateEvent")
    public String updateEvent(
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("month") String month,
        HttpSession session) {
        
        int id = (int) session.getAttribute("id");
        
        Timeline event= new Timeline(id,month,title,description);
        timelineservice.updateEvent(event);

            session.setAttribute("timeline", event);
            return "redirect:/viewTimeLine";
    }

    @RequestMapping("/deleteEventById")
    public String deleteEventById(@RequestParam int id, Model model) {

        boolean success = timelineservice.deleteEventById(id);

        if (success) {

            return "redirect:/viewTimeLine";
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/error"; //need change or delete

    }
    

}
