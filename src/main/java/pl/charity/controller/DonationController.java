package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.charity.entity.Donation;
import pl.charity.repository.DonationRepository;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;

import java.util.List;

@Controller
public class DonationController {

    private CategoryService categoryService;
    private DonationService donationService;
    private InstitutionService institutionService;
    private DonationRepository donationRepository;

    @Autowired
    public DonationController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService, DonationRepository donationRepository) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/form")
    public String donate(Model model) {

        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String confirm(@ModelAttribute Donation donation) {

        donationService.saveDonation(donation);
        System.out.println(donation);
        return "form-confirmation";
    }

    @ModelAttribute
    public Double sum() {
         return donationRepository.sumDonations();
    }


}
