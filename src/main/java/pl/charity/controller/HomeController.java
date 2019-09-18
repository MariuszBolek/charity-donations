package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.entity.Institution;
import pl.charity.repository.DonationRepository;
import pl.charity.repository.InstitutionRepository;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.function.DoubleToLongFunction;

@Controller
public class HomeController {
    private InstitutionService institutionService;
    private DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @ModelAttribute("institutions")
    private List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("donationsCount")
    private Long numberOfDonations() {
        return donationService.numberOfDonations();
    }

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
