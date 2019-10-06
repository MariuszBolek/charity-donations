package pl.charity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.charity.entity.CurrentUser;
import pl.charity.entity.User;
import pl.charity.service.UserService;

import java.security.Principal;
import java.util.Locale;

@RequestMapping("/user")
//@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

    @GetMapping("/edit")
    public String editProfile(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String saveEditProfile(User user, Principal principal) {
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
