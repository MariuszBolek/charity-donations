package pl.charity.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.charity.entity.Donation;
import pl.charity.entity.User;
import pl.charity.service.UserService;
import pl.charity.validation.UserValidationGroup;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginRegisterController {

    private UserService userService;

    public LoginRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String showLoginFormFail(Model model) {
        model.addAttribute("error", "error");
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveRegistrationForm(@ModelAttribute User user, @RequestParam String password2) {
//        if (result.hasErrors()) {
//            return "register";
//        }

//        User existingUser = userService.findByUserName(user.getEmail());
//        if (existingUser != null) {
//            result.addError(new FieldError("user", "email", "Email jest już zajęty"));
//            return "register";
//        }

//        if (!user.getPassword().equals(password2)) {
//            result.addError(new FieldError("user", "password", "Podane hasła nie są jednakowe"));
//            return "register";
//        }

        userService.saveUser(user);
        return "redirect:login";
    }
}



