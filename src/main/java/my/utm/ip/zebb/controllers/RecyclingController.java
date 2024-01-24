package my.utm.ip.zebb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import my.utm.ip.zebb.models.recycleData.RecyclingDAO;
import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.services.recycleData.RecyclingService;

@Controller
@RequestMapping("/recycling")

public class RecyclingController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RecyclingService recyclingService;

    @RequestMapping("/listAllRecyclingData")
    public String home(Model model) {

        List<RecyclingDAO> recycling = recyclingService.getAllRecycleData();
        model.addAttribute("allrecycling", recycling);

        return "RecyclingActivity";  //need change

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

    @RequestMapping("/addRecyclingData")
    public String addRecyclingData(
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

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double sweight = (Double) session.getAttribute("weight");
        int sdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");

        try {
            // Add logging statements
            if(!file.isEmpty())
            {
                System.out.println("File Name: " + file.getOriginalFilename());
                System.out.println("File Size: " + file.getSize());

                RecyclingDAO recycling = new RecyclingDAO();
                recycling.setUserName(userName);
                recycling.setWeight(sweight);
                recycling.setDays(sdays);
                recycling.setMonth(month);
                recycling.setImageName(file.getOriginalFilename());
                recycling.setImageData(file.getBytes());

                double recycling_carbon_factor = recycling.getWeight() * 2.860;
                recycling.setRecycling_carbon_factor(recycling_carbon_factor);

                //RecyclingDAO recycling = new RecyclingDAO(userName, sweight, sdays, month, file.getOriginalFilename(), file.getBytes(), recycling_carbon_factor);
                recyclingService.addRecycleData(recycling);
        
                session.setAttribute("recycling", recycling);
                System.out.println("File uploaded successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/BillPage"; //need change
    }

    @RequestMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(
            @RequestParam String username,
            @RequestParam String month,
            @RequestParam String image_name) {

            try {
                String sql = "SELECT image_data FROM recycledata WHERE userName=? AND month=? AND image_name = ? LIMIT 1";
                byte[] image_data = jdbcTemplate.queryForObject(sql, byte[].class, username, month, image_name);

                if (image_data != null) {
                    // Log incoming parameters
                    System.out.println("Username: " + username);
                    System.out.println("Month: " + month);
                    System.out.println("Image Name: " + image_name);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    headers.setContentDispositionFormData("attachment", image_name);
                    
                    System.out.println("File retrieved successfully");
                    return new ResponseEntity<>(image_data, headers, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

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
