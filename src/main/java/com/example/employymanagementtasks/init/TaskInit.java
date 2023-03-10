package com.example.employymanagementtasks.init;

import com.example.employymanagementtasks.service.TaskPriorityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskInit implements CommandLineRunner {

    private final TaskPriorityService taskService;

    public TaskInit(TaskPriorityService taskService) {
        this.taskService = taskService;
    }


    @Override
    public void run(String... args) {
        this.taskService.initTask();
    }
}
