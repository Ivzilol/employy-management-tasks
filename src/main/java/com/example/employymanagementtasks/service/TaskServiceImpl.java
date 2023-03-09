package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void initTask() {
        if (this.taskRepository.count() == 0) {
            System.out.println("init");
            return;
        }
        Arrays.stream(TaskPriority.values())
                .forEach(task -> {
                    Tasks tasks = new Tasks();
                    tasks.setTaskPriority(task);
                    tasks.setDescription("...");
                    this.taskRepository.save(tasks);
                });

    }
}
