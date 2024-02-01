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

import my.utm.ip.zebb.models.electricalData.ElectricalDAO;
import my.utm.ip.zebb.services.electricalData.ElectricalService;

@Controller
@RequestMapping("/electrical")

public class ElectricalController {

    @Autowired
    private ElectricalService electricalService;

    @RequestMapping("/listAllElectricalData")
    public String home(Model model) {

        List<ElectricalDAO> electrical = electricalService.getAllElectricalData();
        model.addAttribute("electrical", electrical);

        return "competitionUser"; // need change

    }

    @RequestMapping("/viewAddElectricalDataForm")

    public String addElectricalDataForm(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("electrical", new ElectricalDAO());

        return "ElectricalActivity"; // need change

    }

    @RequestMapping("/viewEditElectricalDataForm")

    public String editElectricalDataForm(@RequestParam String userName, String month, Model model) {
        ElectricalDAO electrical = electricalService.getElectricalDataByUserName_month(userName, month);
        model.addAttribute("electrical", electrical);
        model.addAttribute("mode", "edit");

        return "ElectricalActivity"; // need change

    }

    // for testing
    @RequestMapping("/addElectricalData2")
    public String addElectricalData2(
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

        return "UploadElectricity";
    }

    @RequestMapping(value = "/uploadElectricalImage", method = RequestMethod.POST)
    public String uploadElectricalImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

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
                electrical.setElectricityusage(Eelectricityusage);
                electrical.setDays(Edays);
                electrical.setMonth(month);
                electrical.setProportion_factor(Eproportion_factor);
                electrical.setAmount(Eamount);
                electrical.setCurrent_charge(Ecurrent_charge);
                electrical.setImageName(file.getOriginalFilename());
                electrical.setImageData(file.getBytes());

                // ElectricalDAO electrical = new ElectricalDAO(sweight, sdays, month,
                // file.getOriginalFilename(), file.getBytes());
                electricalService.addElectricalData2(electrical);

                session.setAttribute("electrical", electrical);
                System.out.println("File uploaded successfully");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            session.setAttribute("message", "Error uploading file: " + e.getMessage());
        }
        // Redirect to the desired page
        return "redirect:/BillPage"; // need change
    }

}
