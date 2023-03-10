package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import com.example.employymanagementtasks.repository.TaskRepository;
import com.example.employymanagementtasks.repository.TypeOfTasksRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TaskPriorityServiceImpl implements TaskPriorityService {



    private final TypeOfTasksRepository typeOfTasksRepository;

    public TaskPriorityServiceImpl(TaskRepository taskRepository, TypeOfTasksRepository typeOfTasksRepository) {
        this.typeOfTasksRepository = typeOfTasksRepository;
    }

    @Override
    public void initTask() {
        if (this.typeOfTasksRepository.count() != 0) {
            return;
        }
        Arrays.stream(TaskPriority.values())
                .forEach(_taskPriority -> {
                    TypesOfTasks typesOfTasks = new TypesOfTasks();
                    typesOfTasks.setTaskPriority(_taskPriority);
                    typesOfTasks.setDescription("...");
                    this.typeOfTasksRepository.save(typesOfTasks);
                });

    }

    @Override
    public TypesOfTasks findTypeOfTask(TaskPriority taskPriority) {
        return this.typeOfTasksRepository.findTypesOfTasksByTaskPriority(taskPriority).orElseThrow();
    }

    @Override
    public TypesOfTasks findTaskByTaskName(TaskPriority taskPriority) {
        return this.typeOfTasksRepository.findTypesOfTasksByTaskPriority(taskPriority).orElseThrow();
    }


}
