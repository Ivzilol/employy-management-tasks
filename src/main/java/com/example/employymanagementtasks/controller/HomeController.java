package com.example.employymanagementtasks.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name = "/")
public interface HomeController {

    @GetMapping
    String index();

    @GetMapping("/home")
    String home(Model model);

    @GetMapping("/home/add-task-to-task-list/{id}")
    String addTaskToTaskList(@PathVariable("id") Long id);

    @GetMapping("/home/remove-task-from-task-list/{id}")
    String removeTaskFromTaskList(@PathVariable("id") Long id);

    @GetMapping("/home/remove-all-task-from-task-list")
    String deleteAllFromTaskList();

}
