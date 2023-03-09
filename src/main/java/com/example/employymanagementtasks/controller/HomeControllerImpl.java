package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.util.LoggedUser;

public class HomeControllerImpl implements HomeController{

    private final LoggedUser loggedUser;

    public HomeControllerImpl(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }


    @Override
    public String index() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }
}
