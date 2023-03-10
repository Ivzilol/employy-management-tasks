package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.TaskByPriorityDTO;
import com.example.employymanagementtasks.model.dto.TaskDTO;
import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HomeService {


    private final TaskService taskService;

    private final TaskPriorityService taskPriorityService;

    public HomeService(TaskService taskService, TaskPriorityService taskPriorityService) {
        this.taskService = taskService;
        this.taskPriorityService = taskPriorityService;
    }

    public TaskByPriorityDTO getTasks() {
        TaskByPriorityDTO tasks = new TaskByPriorityDTO();
        tasks.setImportant(this.getTasksByPriority(taskPriorityService
                .findTaskByTaskName(TaskPriority.IMPORTANT)));
        tasks.setAverage(this.getTasksByPriority(taskPriorityService
                .findTaskByTaskName(TaskPriority.AVERAGE)));
        tasks.setAverage(this.getTasksByPriority(taskPriorityService
                .findTaskByTaskName(TaskPriority.UNIMPORTANT)));
        return tasks;
    }

    private Set<TaskDTO> getTasksByPriority(TypesOfTasks typesOfTasks) {
        return this.taskService.findTaskByPriority(typesOfTasks);
    }

}
