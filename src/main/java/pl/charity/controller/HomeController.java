package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.repository.InstitutionRepository;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;

import javax.servlet.http.HttpSession;

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

    @RequestMapping("/")
    public String homePage(Model model, HttpSession session) {


        return "index";
    }
}
