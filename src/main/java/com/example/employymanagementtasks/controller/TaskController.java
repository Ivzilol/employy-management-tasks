package com.example.employymanagementtasks.controller;

import com.example.employymanagementtasks.model.dto.AddTaskDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/tasks")
public interface TaskController {

    @GetMapping("add-task")
    String addTask();

    @PostMapping("/add-task")
    String addTask(@Valid AddTaskDTO addTaskDTO, BindingResult result, RedirectAttributes redirectAttributes);

}
