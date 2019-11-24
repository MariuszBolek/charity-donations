package pl.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.charity.entity.Institution;
import pl.charity.entity.User;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;
import pl.charity.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class AdminController {
    private UserService userService;
    private CategoryService categoryService;
    private DonationService donationService;
    private InstitutionService institutionService;

    public AdminController(UserService userService, CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @RequestMapping("")
    public String adminPanel() {
        return "admin/panel";
    }

    //Managing Users
    @GetMapping("/users/manage")
    public String adminUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users/manage";
    }

    @GetMapping("/user/details")
    public String userDetails(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/users/details";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/admin/users/manage";
    }

    @GetMapping("/user/status")
    public String setStatus(@RequestParam Long id) {
        User user = userService.findById(id);
        if (user.isEnabled()) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        userService.saveEditUser(user);
        return "redirect:/admin/users/manage";
    }

    //Managing Institutions
    @GetMapping("/institutions/manage")
    public String manageInstitutions(Model model) {
        model.addAttribute("institution", institutionService.findAll());
        return "admin/institutions/manage";
    }

    @GetMapping("/institutions/details")
    public String institutionDetails(@RequestParam Long id, Model model) {
        model.addAttribute("institution", institutionService.findById(id));
        return "admin/institutions/details";
    }

    @GetMapping("/institutions/delete")
    public String deleteInstitution(@RequestParam Long id) {
        institutionService.delete(id);
        return "redirect:/admin/institutions/manage";
    }

    @GetMapping("/institutions/edit")
    public String editInstitution(Long id, Model model) {
        model.addAttribute("institution", institutionService.findById(id));
        return "/admin/institutions/edit";
    }

    @PostMapping("/institutions/edit")
    public String saveEditInstitution(@RequestParam Long id, @Valid Institution institution, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/institutions/manage";
        }

        institutionService.edit(id, institution);

        return "redirect:/admin/institutions/manage";
    }


    //Managing Donations


    //Superadmin actions



}
