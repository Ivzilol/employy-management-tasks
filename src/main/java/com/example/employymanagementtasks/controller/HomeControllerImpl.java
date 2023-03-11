package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.model.dto.TaskByPriorityDTO;
import com.example.employymanagementtasks.service.HomeService;
import com.example.employymanagementtasks.service.TaskService;
import com.example.employymanagementtasks.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeControllerImpl implements HomeController{

    private final LoggedUser loggedUser;

    private final HomeService homeService;

    private final TaskService taskService;

    public HomeControllerImpl(LoggedUser loggedUser, HomeService homeService, TaskService taskService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
        this.taskService = taskService;
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
        model.addAttribute("tasks", this.homeService.getTasks());
        model.addAttribute("taskList", this.taskService.getTaskList(loggedUser.getId()));
        return "home";
    }

    @Override
    public String addTaskToTaskList(Long id) {
        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }
        this.homeService.addTask(id, this.loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String removeTaskFromTaskList(Long id) {
        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }
        this.homeService.removeTask(id, this.loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String deleteAllFromTaskList() {
        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }
        this.homeService.deleteAll(this.loggedUser.getId());
        return "redirect:/home";
    }


    @ModelAttribute
    public TaskByPriorityDTO tasks(){
        return new TaskByPriorityDTO();
    }


}
