package my.utm.ip.zebb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import my.utm.ip.zebb.models.recycleData.RecyclingDAO;
import my.utm.ip.zebb.services.recycleData.RecyclingService;

@Controller
@RequestMapping("/recycling")

public class RecyclingController {

    @Autowired
    private RecyclingService recyclingService;

    @RequestMapping("/listAllRecyclingData")
    public String home(Model model) {

        List<RecyclingDAO> recycling = recyclingService.getAllRecycleData();
        model.addAttribute("recycling", recycling);

        return "competitionUser"; //need change

    }

    @RequestMapping("/viewAddRecyclingDataForm")

    public String addRecyclingDataForm(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("recyling", new RecyclingDAO());

        return "RecyclingActivity"; //need change

    }

    @RequestMapping("/viewEditRecyclingDataForm")

    public String editRecyclingDataForm(@RequestParam String userName, String month, Model model) {
        RecyclingDAO recycling = recyclingService.getRecycleDataByUserName_month(userName, month);
        model.addAttribute("recycling", recycling);
        model.addAttribute("mode", "edit");

        return "RecyclingActivity"; //need change

    }

    // @RequestMapping("/addRecyclingData1")
    // public String addRecyclingData1(
    //         @RequestParam("userName") String userName,
    //         @RequestParam("weight") String sweight,
    //         @RequestParam("days") String sdays,
    //         @RequestParam("months") String smonths,
    //         @RequestParam("image_name") String simage_name,
    //         @RequestParam("image_data") byte[] simage_data,
    //         @RequestParam("image_type") String simage_type) {
    //     double weight = Double.parseDouble(sweight);
    //     int days = Integer.parseInt(sdays);
    //     byte[]image_data = simage_data;
    //     RecyclingDAO recycle = new RecyclingDAO(userName, weight, days, smonths, simage_name, image_data, simage_type);
    //     recyclingService.addRecycleData1(recycle);

    //     return "RecyclingActivity"; //need change
    // }

    //for testing
    @RequestMapping("/addRecyclingData2")
    public String addRecyclingData2(
            @RequestParam("weight") String weight,
            @RequestParam("days") String days,
            @RequestParam("month") String month,
            HttpSession session) {
        double sweight = Double.parseDouble(weight);
        int sdays = Integer.parseInt(days);
        
        session.setAttribute("weight", sweight);
        session.setAttribute("days", sdays);
        session.setAttribute("month", month);

        return "redirect:/recycling/viewUploadRecyclingForm"; //in Home Controller Request Mapping //need change
        
    }

    @RequestMapping("/viewUploadRecyclingForm")
    public String viewUploadRecyclingForm(
            HttpSession session ) {
        // Access the weight and days attributes
        double sweight = (Double) session.getAttribute("weight");
        int sdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");

        session.setAttribute("weight", sweight);
        session.setAttribute("days", sdays);
        session.setAttribute("month", month);

        return "UploadRecycling";
    }

    @RequestMapping(value = "/uploadRecyclingImage", method = RequestMethod.POST)
    public String uploadRecyclingImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        double sweight = (Double) session.getAttribute("weight");
        int sdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");

        try {
            // Add logging statements
            if(!file.isEmpty())
            {
                System.out.println("File Name: " + file.getOriginalFilename());
                System.out.println("File Size: " + file.getSize());
                System.out.println("File uploaded successfully");

                RecyclingDAO recycling = new RecyclingDAO();
                recycling.setWeight(sweight);
                recycling.setDays(sdays);
                recycling.setMonth(month);
                recycling.setImageName(file.getOriginalFilename());
                recycling.setImageData(file.getBytes());

                //RecyclingDAO recycling = new RecyclingDAO(sweight, sdays, month, file.getOriginalFilename(), file.getBytes());
                recyclingService.addRecycleData2(recycling);
        
                session.setAttribute("recycling", recycling);
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/BillPage"; //need change
    }
    


    // @RequestMapping("/editRecyclingData1")
    // public String editRecyclingData(
    //         @RequestParam("userName") String userName,
    //         @RequestParam("weight") String sweight,
    //         @RequestParam("days") String sdays,
    //         @RequestParam("months") String smonths,
    //         @RequestParam("image_name") String simage_name,
    //         @RequestParam("image_data") byte[] simage_data,
    //         @RequestParam("image_type") String simage_type) {
    //     double weight = Double.parseDouble(sweight);
    //     int days = Integer.parseInt(sdays);
    //     byte[]image_data = simage_data;
    //     RecyclingDAO recycle = new RecyclingDAO(userName, weight, days, smonths, simage_name, image_data, simage_type);
    //     recyclingService.updateRecycleData(recycle);

    //     return "redirect:RecyclingActivity"; //need change

    // }

    // @RequestMapping("/editRecyclingData2") //for testing

    // public String editRecyclingData2(
    //         @RequestParam("weight") String sweight,
    //         @RequestParam("days") String sdays) {
    //     double weight = Double.parseDouble(sweight);
    //     int days = Integer.parseInt(sdays);
    //     RecyclingDAO recycle = new RecyclingDAO(weight, days);
    //     recyclingService.updateRecycleData(recycle);

    //     return "redirect:RecyclingActivity"; //need change
    // }

    // @RequestMapping("/deleteRecyclingData")

    // public String deleteRecyclingData(@RequestParam String userName, String month, Model model) {

    //     boolean success = recyclingService.deleteRecycleData(userName, month);

    //     if (success) {

    //         return "redirect:RecyclingActivity"; //need change
    //     }

    //     model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
    //     return "/product/error"; //need change or delete

    // }

}
