package pl.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.charity.entity.Donation;
import pl.charity.entity.User;
import pl.charity.service.UserService;

@Controller
public class LoginRegisterController {

    private UserService userService;

    public LoginRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping(path = "/register")
    public String saveUser(@ModelAttribute User user, BindingResult result, @RequestParam String password2) {
        if (result.hasErrors()) {
            return "/register";
        }

        User existingUser = userService.findFirstByEmail(user.getEmail());

        if (existingUser != null) {
            result.addError(new FieldError("user", "email",
                    "Podany e-mail jest już zajęty"));
            return "/register";
        }

        if (!user.getPassword().equals(password2)) {
            result.addError(new FieldError("user", "password",
                    "Hasła różnią się od siebie"));
            return "/register";
        }

        userService.saveUser(user);

        return "redirect:login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String formConfirm() {

        return "/login";
    }

}
