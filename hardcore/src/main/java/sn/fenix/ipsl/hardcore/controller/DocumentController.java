package sn.fenix.ipsl.hardcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentController {

    @GetMapping("/document")
    public String evaluations(){
        return "document";
    }
}
