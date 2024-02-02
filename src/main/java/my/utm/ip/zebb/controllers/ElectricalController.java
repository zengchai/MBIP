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

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;
import my.utm.ip.zebb.models.user.User;
import my.utm.ip.zebb.services.electricalData.ElectricalService;

@Controller
@RequestMapping("/electrical")

public class ElectricalController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ElectricalService electricalService;

    @RequestMapping("/listAllElectricalData") // for admin
    public String home(Model model) {

        List<ElectricalDAO> electrical = electricalService.getAllElectricalData();
        model.addAttribute("allelectrical", electrical);

        return "electrical/ElectricityConsumption"; // need change

    }

    @RequestMapping("/listElectricalDataByUsername_Month/{userName}")
    public String userhome(@PathVariable("userName") String userName, Model model) {

        List<ElectricalDAO> electrical = electricalService.getElectricalDataByUserName(userName);
        model.addAttribute("userelectrical", electrical);

        return "electrical/ElectricalHome"; // need change

    }

    @RequestMapping("/viewAddElectricalDataForm")

    public String addElectricalDataForm(HttpSession session) {

        session.setAttribute("mode", "add");
        session.setAttribute("electrical", new ElectricalDAO());

        return "electrical/ElectricityConsumption"; // need change

    }

    @RequestMapping("/addElectricalData")
    public String addElectricalData(
            @RequestParam("electricityusage") String electricityusage,
            @RequestParam("days") String days,
            @RequestParam("month") String month,
            @RequestParam("proportion_factor") String proportion_factor,
            @RequestParam("amount") String amount,
            @RequestParam("current_charge") String current_charge,
            HttpSession session) {
        double Eelectricityusage = Double.parseDouble(electricityusage);
        int Edays = Integer.parseInt(days);
        double Eproportion_factor = Double.parseDouble(proportion_factor);
        double Eamount = Double.parseDouble(amount);
        double Ecurrent_charge = Double.parseDouble(current_charge);

        session.setAttribute("electricityusage", Eelectricityusage);
        session.setAttribute("days", Edays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Eproportion_factor);
        session.setAttribute("amount", Eamount);
        session.setAttribute("current_charge", Ecurrent_charge);

        return "redirect:/electrical/viewUploadElectricalForm"; // in Home Controller Request Mapping //need change

    }

    @RequestMapping("/viewUploadElectricalForm")
    public String viewUploadElectricalForm(
            HttpSession session) {
        // Access the weight and days attributes
        double Eelectricityusage = (Double) session.getAttribute("electricityusage");
        int Edays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Eproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Eamount = (Double) session.getAttribute("amount");
        double Ecurrent_charge = (Double) session.getAttribute("current_charge");

        session.setAttribute("electricityusage", Eelectricityusage);
        session.setAttribute("days", Edays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Eproportion_factor);
        session.setAttribute("amount", Eamount);
        session.setAttribute("current_charge", Ecurrent_charge);
        session.setAttribute("mode", "add");

        return "electrical/UploadElectricity";
    }

    @RequestMapping(value = "/uploadElectricalImage", method = RequestMethod.POST)
    public String uploadElectricalImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double Eelectricityusage = (Double) session.getAttribute("electricityusage");
        int Edays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Eproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Eamount = (Double) session.getAttribute("amount");
        double Ecurrent_charge = (Double) session.getAttribute("current_charge");

        try {
            // Add logging statements
            if (!file.isEmpty()) {
                System.out.println("File Name: " + file.getOriginalFilename());
                System.out.println("File Size: " + file.getSize());

                ElectricalDAO electrical = new ElectricalDAO();
                electrical.setUserName(userName);
                electrical.setElectricityusage(Eelectricityusage);
                electrical.setDays(Edays);
                electrical.setMonth(month);
                electrical.setProportion_factor(Eproportion_factor);
                electrical.setAmount(Eamount);
                electrical.setCurrent_charge(Ecurrent_charge);
                electrical.setImageName(file.getOriginalFilename());
                electrical.setImageData(file.getBytes());
                
                double electrical_carbon_factor = electrical.getElectricityusage() * 0.584;
                electrical.setElectrical_carbon_factor(electrical_carbon_factor);
                electricalService.addElectricalData(electrical);

                session.setAttribute("electrical", electrical);
                System.out.println("File uploaded successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/electrical/listElectricalDataByUsername_Month/" + userName; // need change
    }

    @RequestMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(
            @RequestParam String username,
            @RequestParam String month,
            @RequestParam String image_name) {

        try {
            String sql = "SELECT image_data FROM electricaldata WHERE userName=? AND month=? AND image_name = ? LIMIT 1";
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

    @RequestMapping("/viewEditElectricalDataForm")
    public String editElectricalDataForm(
            @RequestParam("month") String month,
            HttpSession session) {

        session.setAttribute("month", month);
        session.setAttribute("mode", "edit");

        return "electrical/ElectricityConsumption";

    }

    @RequestMapping("/editElectricalData")
    public String editElectricalData(
            @RequestParam("electricityusage") String electricityusage,
            @RequestParam("days") String days,
            @RequestParam("proportion_factor") String proportion_factor,
            @RequestParam("amount") String amount,
            @RequestParam("current_charge") String current_charge,
            HttpSession session) {
        double Eelectricityusage = Double.parseDouble(electricityusage);
        int Edays = Integer.parseInt(days);
        double Eproportion_factor = Double.parseDouble(proportion_factor);
        double Eamount = Double.parseDouble(amount);
        double Ecurrent_charge = Double.parseDouble(current_charge);
        String month = (String) session.getAttribute("month");

        session.setAttribute("electricityusage", Eelectricityusage);
        session.setAttribute("days", Edays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Eproportion_factor);
        session.setAttribute("amount", Eamount);
        session.setAttribute("current_charge", Ecurrent_charge);

        return "redirect:/electrical/viewEditUploadElectricalForm"; // in Home Controller Request Mapping //need change

    }

    @RequestMapping("/viewEditUploadElectricalForm")
    public String viewEditUploadElectricalForm(
            HttpSession session) {
        // Access the weight and days attributes
        double Eelectricityusage = (Double) session.getAttribute("electricityusage");
        int Edays = (Integer) session.getAttribute("days");
        String month = (String) session.getAttribute("month");
        double Eproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Eamount = (Double) session.getAttribute("amount");
        double Ecurrent_charge = (Double) session.getAttribute("current_charge");

        session.setAttribute("electricityusage", Eelectricityusage);
        session.setAttribute("days", Edays);
        session.setAttribute("month", month);
        session.setAttribute("proportion_factor", Eproportion_factor);
        session.setAttribute("amount", Eamount);
        session.setAttribute("current_charge", Ecurrent_charge);
        session.setAttribute("mode", "edit");

        return "electrical/UploadElectricity";
    }

    @RequestMapping(value = "/editElectricalImage", method = RequestMethod.POST)
    public String editElectricalImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        double Eelectricityusage = (Double) session.getAttribute("electricityusage");
        int Edays = (Integer) session.getAttribute("days");
        double Eproportion_factor = (Double) session.getAttribute("proportion_factor");
        double Eamount = (Double) session.getAttribute("amount");
        double Ecurrent_charge = (Double) session.getAttribute("current_charge");
        String month = (String) session.getAttribute("month");

        try {
            // Add logging statements
            if (!file.isEmpty()) {
                System.out.println("File Name: " + file.getOriginalFilename());
                System.out.println("File Size: " + file.getSize());

                ElectricalDAO electrical = new ElectricalDAO();
                electrical.setUserName(userName);
                electrical.setElectricityusage(Eelectricityusage);
                electrical.setDays(Edays);
                electrical.setMonth(month);
                electrical.setProportion_factor(Eproportion_factor);
                electrical.setAmount(Eamount);
                electrical.setCurrent_charge(Ecurrent_charge);
                electrical.setImageName(file.getOriginalFilename());
                electrical.setImageData(file.getBytes());

                double electrical_carbon_factor = electrical.getElectricityusage() * 0.584;
                electrical.setElectrical_carbon_factor(electrical_carbon_factor);

                electricalService.updateElectricalData(electrical);

                session.setAttribute("electrical", electrical);
                System.out.println("File edited successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/electrical/listElectricalDataByUsername_Month/" + userName; // need change
    }

    @RequestMapping("/deleteElectricalData")

    public String deleteElectricalData(@RequestParam String month, HttpSession session, Model model) {
        User curuser = (User) session.getAttribute("user");
        String userName = curuser.getUsername();
        boolean success = electricalService.deleteElectricalData(month);

        if (success) {

            return "redirect:/electrical/listElectricalDataByUsername_Month/" + userName; // need change
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/product/error"; // need change or delete

    }

}
