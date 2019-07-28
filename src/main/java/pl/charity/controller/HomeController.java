package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private CategoryService categoryService;
    private DonationService donationService;
    private InstitutionService institutionService;


    @Autowired

    public HomeController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @RequestMapping(value = {"/", "/index"})
    public String homePage(Model model, HttpSession session) {
        Integer total = donationService.sumDonations();
        model.addAttribute("total", total);

        Integer count = institutionService.countInstitutions();
        model.addAttribute("count", count);

        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("institution", institutions);


        return "index";
    }
}
