package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TaskPriorityServiceImpl implements TaskPriorityService {

    private final TaskRepository taskRepository;

    public TaskPriorityServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void initTask() {
        if (this.taskRepository.count() == 0) {
            System.out.println("init");
            return;
        }
        Arrays.stream(com.example.employymanagementtasks.model.entity.TaskPriority.values())
                .forEach(task -> {
                    Tasks tasks = new Tasks();
                    tasks.setDescription("...");
                    this.taskRepository.save(tasks);
                });

    }




}
