package sn.fenix.ipsl.hardcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AproposController {

    @GetMapping("/apropos")
    public String aPropos(){
        return "aPropos";
    }
}
