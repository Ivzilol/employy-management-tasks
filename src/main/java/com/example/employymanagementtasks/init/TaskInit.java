package com.example.employymanagementtasks.init;

import com.example.employymanagementtasks.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskInit implements CommandLineRunner {

    private final TaskService taskService;

    public TaskInit(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public void run(String... args) {
        this.taskService.initTask();
    }
}
