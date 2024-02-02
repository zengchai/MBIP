package my.utm.ip.zebb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/listAllRecyclingData") //for admin
    public String home(Model model) {

        List<RecyclingDAO> recycling = recyclingService.getAllRecycleData();
        model.addAttribute("allrecycling", recycling);

        return "recycling/RecyclingActivity";  //need change

    }

    @RequestMapping("/listRecyclingDataByUsername_Month/{userName}")
    public String userhome(@PathVariable("userName") String userName, Model model) {

        List<RecyclingDAO> recycling = recyclingService.getRecycleDataByUserName(userName);
        model.addAttribute("userrecycling", recycling);

        return "recycling/RecyclingHome";  //need change

    }

    @RequestMapping("/viewAddRecyclingDataForm")

    public String addRecyclingDataForm(HttpSession session) {

        session.setAttribute("mode", "add");
        session.setAttribute("recyling", new RecyclingDAO());

        return "recycling/RecyclingActivity"; //need change

    }

    @RequestMapping("/addRecyclingData")
    public String addRecyclingData(
            @RequestParam("weight") String weight,
            @RequestParam("month") String month,
            HttpSession session) {
        double sweight = Double.parseDouble(weight);
        
        session.setAttribute("weight", sweight);
        session.setAttribute("month", month);

        return "redirect:/recycling/viewUploadRecyclingForm"; //in Home Controller Request Mapping //need change
        
    }

    @RequestMapping("/viewUploadRecyclingForm")
    public String viewUploadRecyclingForm(
            HttpSession session ) {
        // Access the weight and days attributes
        double sweight = (Double) session.getAttribute("weight");
        String month = (String) session.getAttribute("month");

        session.setAttribute("weight", sweight);
        session.setAttribute("month", month);
        session.setAttribute("mode", "add");

        return "recycling/UploadRecycling";
    }

    @RequestMapping(value = "/uploadRecyclingImage", method = RequestMethod.POST)
    public String uploadRecyclingImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double sweight = (Double) session.getAttribute("weight");
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
        return "redirect:/recycling/listRecyclingDataByUsername_Month/"+ userName; //need change
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

    //==============================================================================================================================

    @RequestMapping("/viewEditRecyclingDataForm")
    public String editRecyclingDataForm(  
            @RequestParam("month") String month,
            HttpSession session) {
        
        session.setAttribute("month", month);
        session.setAttribute("mode", "edit");

        return "recycling/RecyclingActivity";

    }

    @RequestMapping("/editRecyclingData")
    public String editRecyclingData(
            @RequestParam("weight") String weight,
            HttpSession session) {
        double sweight = Double.parseDouble(weight);
        String month = (String) session.getAttribute("month");

        session.setAttribute("weight", sweight);
        session.setAttribute("month", month);
        

        return "redirect:/recycling/viewEditUploadRecyclingForm"; //in Home Controller Request Mapping //need change
        
    }

    @RequestMapping("/viewEditUploadRecyclingForm")
    public String viewEditUploadRecyclingForm(
            HttpSession session) {
        // Access the weight and days attributes
        double sweight = (Double) session.getAttribute("weight");
        String month = (String) session.getAttribute("month");

        session.setAttribute("weight", sweight);
        session.setAttribute("month", month);
        session.setAttribute("mode", "edit");

        return "recycling/UploadRecycling";
    }

    @RequestMapping(value = "/editRecyclingImage", method = RequestMethod.POST)
    public String editRecyclingImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double sweight = (Double) session.getAttribute("weight");
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
                recycling.setMonth(month);
                recycling.setImageName(file.getOriginalFilename());
                recycling.setImageData(file.getBytes());

                double recycling_carbon_factor = recycling.getWeight() * 2.860;
                recycling.setRecycling_carbon_factor(recycling_carbon_factor);

                //RecyclingDAO recycling = new RecyclingDAO(userName, sweight, sdays, month, file.getOriginalFilename(), file.getBytes(), recycling_carbon_factor);
                recyclingService.updateRecycleData(recycling);
        
                session.setAttribute("recycling", recycling);
                System.out.println("File edited successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/recycling/listRecyclingDataByUsername_Month/"+ userName; //need change
    }


    @RequestMapping("/deleteRecyclingData")

    public String deleteRecyclingData(@RequestParam String month, HttpSession session, Model model) {
        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        boolean success = recyclingService.deleteRecycleData(month);

        if (success) {

            return "redirect:/recycling/listRecyclingDataByUsername_Month/"+ userName; //need change
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/product/error"; //need change or delete

    }

}
