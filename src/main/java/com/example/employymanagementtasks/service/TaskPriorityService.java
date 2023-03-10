package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;

public interface TaskPriorityService {

    void initTask();

    TypesOfTasks findTypeOfTask(TaskPriority taskPriority);

    TypesOfTasks findTaskByTaskName(TaskPriority taskPriority);


}
