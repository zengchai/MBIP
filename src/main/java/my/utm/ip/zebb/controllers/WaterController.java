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

import my.utm.ip.zebb.models.waterData.WaterDAO;
import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.services.waterData.WaterService;

@Controller
@RequestMapping("/water")

public class WaterController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WaterService waterService;

    @RequestMapping("/listAllWaterData") // for admin
    public String home(Model model) {

        List<WaterDAO> water = waterService.getAllWaterData();
        model.addAttribute("allwater", water);

        return "water/WaterConsumption"; // need change

    }

    @RequestMapping("/listWaterDataByUsername_Month/{userName}")
    public String userhome(@PathVariable("userName") String userName, Model model) {

        List<WaterDAO> water = waterService.getWaterDataByUserName(userName);
        model.addAttribute("userwater", water);

        return "water/WaterHome"; // need change

    }

    @RequestMapping("/viewAddWaterDataForm")

    public String addWaterDataForm(HttpSession session) {

        session.setAttribute("mode", "add");
        session.setAttribute("water", new WaterDAO());

        return "water/WaterConsumption"; // need change

    }

    @RequestMapping("/addWaterData")
    public String addWaterData(
            @RequestParam("waterusage") String waterusage,
            @RequestParam("days") String days,
            @RequestParam("month") String month,
            @RequestParam("proportion_factor") String proportion_factor,
            @RequestParam("amount") String amount,
            HttpSession session) {
        double Wwaterusage = Double.parseDouble(waterusage);
        int Wdays = Integer.parseInt(days);
        double Wproportion_factor = Double.parseDouble(proportion_factor);
        double Wamount = Double.parseDouble(amount);

        session.setAttribute("waterusage", Wwaterusage);
        session.setAttribute("days", Wdays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Wproportion_factor);
        session.setAttribute("amount", Wamount);

        return "redirect:/water/viewUploadWaterForm"; // in Home Controller Request Mapping //need change

    }

    @RequestMapping("/viewUploadWaterForm")
    public String viewUploadWaterForm(
            HttpSession session) {
        // Access the weight and days attributes
        double Wwaterusage = (Double) session.getAttribute("waterusage");
        int Wdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Wproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Wamount = (Double) session.getAttribute("amount");

        session.setAttribute("waterusage", Wwaterusage);
        session.setAttribute("days", Wdays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Wproportion_factor);
        session.setAttribute("amount", Wamount);
        session.setAttribute("mode", "add");

        return "water/UploadWater";
    }

    @RequestMapping(value = "/uploadWaterImage", method = RequestMethod.POST)
    public String uploadWaterImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double Wwaterusage = (Double) session.getAttribute("waterusage");
        int Wdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Wproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Wamount = (Double) session.getAttribute("amount");

        try {
            // Add logging statements
            if (!file.isEmpty()) {
                System.out.println("File Name: " + file.getOriginalFilename());
                System.out.println("File Size: " + file.getSize());

                WaterDAO water = new WaterDAO();
                water.setUserName(userName);
                water.setWaterusage(Wwaterusage);
                water.setDays(Wdays);
                water.setMonth(month);
                water.setProportion_factor(Wproportion_factor);
                water.setAmount(Wamount);
                water.setImageName(file.getOriginalFilename());
                water.setImageData(file.getBytes());

                // WaterDAO water = new WaterDAO(userName, sweight, sdays, month,
                // file.getOriginalFilename(), file.getBytes(), water_carbon_factor);
                waterService.addWaterData(water);

                session.setAttribute("water", water);
                System.out.println("File uploaded successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/water/listWaterDataByUsername_Month/" + userName; // need change
    }

    @RequestMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(
            @RequestParam String username,
            @RequestParam String month,
            @RequestParam String image_name) {

        try {
            String sql = "SELECT image_data FROM waterdata WHERE userName=? AND month=? AND image_name = ? LIMIT 1";
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

    // ==============================================================================================================================

    @RequestMapping("/viewEditWaterDataForm")
    public String editWaterDataForm(
            @RequestParam("month") String month,
            HttpSession session) {

        session.setAttribute("month", month);
        session.setAttribute("mode", "edit");

        return "water/WaterConsumption";

    }

    @RequestMapping("/editWaterData")
    public String editWaterData(
            @RequestParam("waterusage") String waterusage,
            @RequestParam("days") String days,
            @RequestParam("proportion_factor") String proportion_factor,
            @RequestParam("amount") String amount,
            HttpSession session) {
        double Wwaterusage = Double.parseDouble(waterusage);
        int Wdays = Integer.parseInt(days);
        double Wproportion_factor = Double.parseDouble(proportion_factor);
        double Wamount = Double.parseDouble(amount);
        String month = (String) session.getAttribute("month");

        session.setAttribute("waterusage", Wwaterusage);
        session.setAttribute("days", Wdays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Wproportion_factor);
        session.setAttribute("amount", Wamount);

        return "redirect:/water/viewEditUploadWaterForm"; // in Home Controller Request Mapping //need change

    }

    @RequestMapping("/viewEditUploadWaterForm")
    public String viewEditUploadWaterForm(
            HttpSession session) {
        // Access the weight and days attributes
        double Wwaterusage = (Double) session.getAttribute("waterusage");
        int Wdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Wproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Wamount = (Double) session.getAttribute("amount");

        session.setAttribute("waterusage", Wwaterusage);
        session.setAttribute("days", Wdays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Wproportion_factor);
        session.setAttribute("amount", Wamount);
        session.setAttribute("mode", "edit");

        return "water/UploadWater";
    }

    @RequestMapping(value = "/editWaterImage", method = RequestMethod.POST)
    public String editWaterImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double Wwaterusage = (Double) session.getAttribute("waterusage");
        int Wdays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Wproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Wamount = (Double) session.getAttribute("amount");

        try {
            // Add logging statements
            if (!file.isEmpty()) {
                System.out.println("File Name: " + file.getOriginalFilename());
                System.out.println("File Size: " + file.getSize());

                WaterDAO water = new WaterDAO();
                water.setUserName(userName);
                water.setWaterusage(Wwaterusage);
                water.setDays(Wdays);
                water.setMonth(month);
                water.setProportion_factor(Wproportion_factor);
                water.setAmount(Wamount);
                water.setImageName(file.getOriginalFilename());
                water.setImageData(file.getBytes());

                // WaterDAO water = new WaterDAO(userName, sweight, sdays, month,
                // file.getOriginalFilename(), file.getBytes(), water_carbon_factor);
                waterService.updateWaterData(water);

                session.setAttribute("water", water);
                System.out.println("File edited successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/water/listWaterDataByUsername_Month/" + userName; // need change
    }

    @RequestMapping("/deleteWaterData")

    public String deleteWaterData(@RequestParam String month, HttpSession session, Model model) {
        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        boolean success = waterService.deleteWaterData(month);

        if (success) {

            return "redirect:/water/listWaterDataByUsername_Month/" + userName; // need change
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/product/error"; // need change or delete

    }

}
