package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.entity.Category;
import pl.charity.entity.Donation;
import pl.charity.entity.Institution;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;

import java.util.List;

@Controller
public class FormConfirmationController {

    private CategoryService categoryService;
    private DonationService donationService;
    private InstitutionService institutionService;


    @Autowired
    public FormConfirmationController(CategoryService categoryService,
                              DonationService donationService,
                              InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;

    }
    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> category() {
        return categoryService.findAll();
    }


    @RequestMapping(path = "/form-confirmation")
    public String formConfirm(@ModelAttribute Donation donation, BindingResult confirmBindingResult) {


        donationService.saveDonation(donation);

        if(confirmBindingResult.hasErrors()) {
            return "/form";
        }


        System.out.println(donation);
        return "form-confirmation";
    }
}
