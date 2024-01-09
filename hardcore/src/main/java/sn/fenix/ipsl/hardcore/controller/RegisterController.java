package sn.fenix.ipsl.hardcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sn.fenix.ipsl.hardcore.model.UserModel;
import sn.fenix.ipsl.hardcore.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String register(Model model){
        UserModel userModel = new UserModel();
        model.addAttribute("user_model",userModel);
        return "register";
    }

    @PostMapping("/valide_register")
    public String valide_register(UserModel userModel){
        userService.saveUser(userModel);
        return "redirect:/login";
    }

}
