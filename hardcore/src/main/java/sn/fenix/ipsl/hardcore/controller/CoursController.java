package sn.fenix.ipsl.hardcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursController {

    @GetMapping("/cours")
    public String showCours() {
        return "cours";
    }
}
