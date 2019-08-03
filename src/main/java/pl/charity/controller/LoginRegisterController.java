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

    @GetMapping(path = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(path = "/register")
    public String saveUser(@ModelAttribute @Validated({UserValidationGroup.class}) User user, BindingResult result, @RequestParam String password2) {
        if (result.hasErrors()) {

            return "register";
        }

        User existingUser = userService.findFirstByEmail(user.getEmail());

        if (existingUser != null) {
            result.addError(new FieldError("user",  "email",
                    "Podany e-mail jest już zajęty"));
            return "register";
        }

        if (!user.getPassword().equals(password2)) {
            result.addError(new FieldError("user", "password",
                    "Hasła różnią się od siebie"));
            return "register";
        }

        userService.saveUser(user);

        return "redirect:/login";
    }

    @GetMapping(path = "login")
    public String getLogin(Model model) {
//        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping(path = "/login")
    public String postLogin(Model model) {
        model.addAttribute("error", "Błędne dane");

//
//    boolean loggedIn = true;
//    User existingUser = userService.findFirstByEmail(user.getEmail());
//        if (existingUser == null) {
//            loggedIn = false;
//        } else if (!BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
//            loggedIn = false;
//        }
//
////        if (!loggedIn) {
//            result.addError(new FieldError("user", "email",
//                    "Incorrect email or password"));
//            return "/login";
//        }

//        session.setAttribute("user", existingUser);


        return "redirect:/index";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }



}
