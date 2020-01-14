package pl.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.charity.entity.*;
import pl.charity.service.CategoryService;
import pl.charity.service.DonationService;
import pl.charity.service.InstitutionService;
import pl.charity.service.UserService;
import pl.charity.validation.UserValidationGroup;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@RequestMapping("/user")
@Secured("ROLE_USER")

@Controller
public class UserController {


    private UserService userService;
    private DonationService donationService;
    private InstitutionService institutionService;
    private CategoryService categoryService;

    public UserController(UserService userService, DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.userService = userService;
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("donations")
    public List<Donation> getdonations(@AuthenticationPrincipal CurrentUser currentUser) {
        return donationService.findAllUserDonations(currentUser.getUser().getId());
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "user/profile";
    }

    @PostMapping("/profile")
    public String profile() {
        return "user/profile";
    }


    @GetMapping("/my-donations")
    public String showDonations(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
         return "user/my-donations";
    }

    @PostMapping("/my-donations")
    public String donations() {
        return "user/my-donations";
    }

    @GetMapping("/edit")
    public String editProfile(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String saveEditProfile(@Validated(UserValidationGroup.class) User user, BindingResult result, Principal principal) {
//        if (result.hasErrors()) {
//            return "redirect:/user/profile";
//        }
        userService.saveEditUser(user, principal.getName());
        return "redirect:/user/profile";
    }

    @GetMapping("/editpassword")
    public String editPasssword(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));

        return "user/password-change";
    }

    @PostMapping("/editpassword")
    public String saveEditPassword(@AuthenticationPrincipal CurrentUser currentUser,
                                   @RequestParam String oldPassword,
                                   @RequestParam String newPassword,
                                   @RequestParam String newPasswordConfirm,
                                   Model model) {

        try {
            userService.changePassword(currentUser.getUser().getEmail(), oldPassword, newPassword, newPasswordConfirm);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "error");
            return "user/password-change";
        }

        return "redirect:/user/profile";
    }



}
