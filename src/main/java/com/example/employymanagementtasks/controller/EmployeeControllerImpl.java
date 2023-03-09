package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.model.dto.LoginDTO;
import com.example.employymanagementtasks.model.dto.RegisterDTO;
import com.example.employymanagementtasks.service.UserService;
import com.example.employymanagementtasks.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

    private final LoggedUser loggedUser;

    private final UserService userService;

    public EmployeeControllerImpl(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @Override
    public String login(Model model) {
        if(loggedUser.isLogged()) {
            return "redirect:/home";
        }
        return "login";
    }

    @Override
    public String loginConfirm(LoginDTO loginDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("loginDTO")
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", result);
            return "redirect:/users/login";
        }
        boolean validateCredential = this.userService
                .checkCredential(loginDTO.getUsername(), loginDTO.getPassword());
        if (!validateCredential) {
            redirectAttributes
                    .addFlashAttribute("loginDTO", loginDTO)
                    .addFlashAttribute("validateCredential", false);
            return "redirect:/users/login";
        }
        this.userService.login(loginDTO.getUsername());
        return "redirect:/home";
    }

    @Override
    public String register() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }
        return "register";
    }

    @Override
    public String registerConfirm(RegisterDTO registerDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        return null;
    }

    @ModelAttribute
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validateCredential");
    }
}
