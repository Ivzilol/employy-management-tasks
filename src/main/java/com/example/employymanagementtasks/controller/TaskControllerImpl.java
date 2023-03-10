package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.model.dto.AddTaskDTO;
import com.example.employymanagementtasks.service.TaskServiceImpl;
import com.example.employymanagementtasks.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskControllerImpl implements TaskController {

    private final LoggedUser loggedUser;

    private final TaskServiceImpl taskService;

    public TaskControllerImpl(LoggedUser loggedUser, TaskServiceImpl taskService) {
        this.loggedUser = loggedUser;
        this.taskService = taskService;
    }

    @Override
    public String addTask() {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }
        return "task-add";
    }

    @Override
    public String addTask(AddTaskDTO addTaskDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        return null;
    }


}
