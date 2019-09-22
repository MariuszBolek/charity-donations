package pl.charity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.entity.User;
import pl.charity.service.UserService;

import java.security.Principal;

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

    @GetMapping("/password-change")
    public String editPasssword(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "user/edit";
    }

    @PostMapping("/password-change")
    public String saveEditPassword(User user, Principal principal) {

        return "redirect:/user/profile";
    }

}
