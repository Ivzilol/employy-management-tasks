package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.TaskByPriorityDTO;
import com.example.employymanagementtasks.model.dto.TaskDTO;
import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HomeService {


    private final TaskService taskService;

    private final TaskPriorityService taskPriorityService;

    private final UserService userService;

    public HomeService(TaskService taskService, TaskPriorityService taskPriorityService, UserService userService) {
        this.taskService = taskService;
        this.taskPriorityService = taskPriorityService;
        this.userService = userService;
    }

    public TaskByPriorityDTO getTasks() {
        TaskByPriorityDTO tasks = new TaskByPriorityDTO();
        tasks.setImportant(this.getTasksByPriority(taskPriorityService
                .findTaskByTaskName(TaskPriority.IMPORTANT)));
        tasks.setAverage(this.getTasksByPriority(taskPriorityService
                .findTaskByTaskName(TaskPriority.AVERAGE)));
        tasks.setUnimportant(this.getTasksByPriority(taskPriorityService
                .findTaskByTaskName(TaskPriority.UNIMPORTANT)));
        return tasks;
    }

    private Set<TaskDTO> getTasksByPriority(TypesOfTasks typesOfTasks) {
        return this.taskService.findTaskByPriority(typesOfTasks);
    }

    public void addTask(Long taskId, Long userId) {
        Tasks task = this.taskService.findTaskById(taskId);
        this.userService.addTaskToUser(userId, task);
    }

    public void removeTask(Long taskId, Long userId) {
        this.userService.removeTaskFromUser(taskId, userId);
    }

    public void deleteAll(Long userId) {
        this.userService.deleteAllTasks(userId);
    }
}
