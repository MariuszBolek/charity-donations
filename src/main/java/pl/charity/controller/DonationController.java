package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.charity.entity.Category;
import pl.charity.entity.CurrentUser;
import pl.charity.entity.Donation;
import pl.charity.entity.Institution;
import pl.charity.repository.DonationRepository;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@Secured("ROLE_USER")
public class DonationController {
    private InstitutionService institutionService;
    private CategoryService categoryService;
    private DonationService donationService;

    public DonationController(InstitutionService institutionService, CategoryService categoryService
            , DonationService donationService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService;
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/donate")
    public String donate(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donate")
    public String confirm(@ModelAttribute Donation donation, @AuthenticationPrincipal CurrentUser currentUser) {

        donationService.save(donation, currentUser);
        return "form-confirmation";
    }
}






