package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.model.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeControllerImpl implements EmployeeController {



    @Override
    public String login(Model model) {
        return null;
    }

    @Override
    public String loginConfirm(LoginDTO loginDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        return null;
    }
}
