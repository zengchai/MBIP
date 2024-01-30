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

import my.utm.ip.zebb.models.waterData.WaterDAO;
import my.utm.ip.zebb.services.waterData.WaterService;

@Controller
@RequestMapping("/water")

public class WaterController {

    @Autowired
    private WaterService waterService;

    @RequestMapping("/listAllWaterData")
    public String home(Model model) {

        List<WaterDAO> water = waterService.getAllWaterData();
        model.addAttribute("water", water);

        return "competitionUser"; // need change

    }

    @RequestMapping("/viewAddWaterDataForm")

    public String addWaterDataForm(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("water", new WaterDAO());

        return "WaterActivity"; // need change

    }

    @RequestMapping("/viewEditWaterDataForm")

    public String editWaterDataForm(@RequestParam String userName, String month, Model model) {
        WaterDAO water = waterService.getWaterDataByUserName_month(userName, month);
        model.addAttribute("water", water);
        model.addAttribute("mode", "edit");

        return "WaterActivity"; // need change

    }

    // for testing
    @RequestMapping("/addWaterData2")
    public String addWaterData2(
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

        return "UploadWater";
    }

    @RequestMapping(value = "/uploadWaterImage", method = RequestMethod.POST)
    public String uploadWaterImage(
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

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
                water.setWaterusage(Wwaterusage);
                water.setDays(Wdays);
                water.setMonth(month);
                water.setProportion_factor(Wproportion_factor);
                water.setAmount(Wamount);
                water.setImageName(file.getOriginalFilename());
                water.setImageData(file.getBytes());

                // WaterDAO water = new WaterDAO(sweight, sdays, month,
                // file.getOriginalFilename(), file.getBytes());
                waterService.addWaterData2(water);

                session.setAttribute("water", water);
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
