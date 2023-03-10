package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.service.HomeService;
import com.example.employymanagementtasks.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class HomeControllerImpl implements HomeController{

    private final LoggedUser loggedUser;

    private final HomeService homeService;

    public HomeControllerImpl(LoggedUser loggedUser, HomeService homeService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
    }


    @Override
    public String index() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }
        return "index";
    }

    @Override
    public String home(Model model) {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }


        return "home";
    }


}
