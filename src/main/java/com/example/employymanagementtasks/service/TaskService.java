package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.AddTaskDTO;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(AddTaskDTO addTaskDTO) {
        this.taskRepository.save(this.mapTask(addTaskDTO));
    }

    private Tasks mapTask(AddTaskDTO addTaskDTO) {
        Tasks task = new Tasks();
        task.setTaskPriority(addTaskDTO.getTaskPriority());
        task.setDescription(addTaskDTO.getDescription());
        task.setTitle(addTaskDTO.getTitle());
        task.setStatus(addTaskDTO.getStatus());
        task.setStartDate(addTaskDTO.getStartDate());
        task.setEndDate(addTaskDTO.getEndDate());
        return task;
    }
}
