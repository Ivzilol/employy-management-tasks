package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.TaskByPriorityDTO;
import com.example.employymanagementtasks.model.dto.TaskDTO;
import com.example.employymanagementtasks.model.entity.Tasks;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HomeService {


    private final TaskService taskService;

    public HomeService(TaskService taskService) {
        this.taskService = taskService;
    }


//    public TaskByPriorityDTO getTasks(Tasks tasks) {
//        TaskByPriorityDTO task = new TaskByPriorityDTO();
//        task.setImportant(tasks.getTaskPriority().IMPORTANT);
//
//        return task;
//    }
//
//    private Set<TaskDTO> getTaskByPriority() {
//         this.taskService.findTaskByPriority();
//    }
}
