package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.model.dto.AddTaskDTO;
import com.example.employymanagementtasks.service.TaskService;
import com.example.employymanagementtasks.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskControllerImpl implements TaskController {

    private final LoggedUser loggedUser;

    private final TaskService taskService;

    public TaskControllerImpl(LoggedUser loggedUser, TaskService taskService) {
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
        if (result.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addTaskDTO", addTaskDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addTaskDTO", result);
            return "redirect:/task-add";
        }
        this.taskService.addTask(addTaskDTO);
        return "redirect:/home";
    }

    @ModelAttribute
    public AddTaskDTO addTaskDTO() {
        return new AddTaskDTO();
    }


}
