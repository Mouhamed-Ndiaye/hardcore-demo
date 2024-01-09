package sn.fenix.ipsl.hardcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sn.fenix.ipsl.hardcore.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



}
