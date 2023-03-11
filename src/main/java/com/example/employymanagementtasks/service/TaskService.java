package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.AddTaskDTO;
import com.example.employymanagementtasks.model.dto.TaskDTO;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import com.example.employymanagementtasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    private final TaskPriorityService taskPriorityService;

    public TaskService(TaskRepository taskRepository, TaskPriorityService taskPriorityService) {
        this.taskRepository = taskRepository;
        this.taskPriorityService = taskPriorityService;
    }

    public void addTask(AddTaskDTO addTaskDTO) {
        this.taskRepository.save(this.mapTask(addTaskDTO));
    }

    private Tasks mapTask(AddTaskDTO addTaskDTO) {
        Tasks task = new Tasks();
        TypesOfTasks typesOfTasks = this.taskPriorityService.findTypeOfTask(addTaskDTO.getTaskPriority());
        task.setDescription(addTaskDTO.getDescription());
        task.setTitle(addTaskDTO.getTitle());
        task.setStartDate(addTaskDTO.getStartDate());
        task.setEndDate(addTaskDTO.getEndDate());
        task.setTypesOfTasks(typesOfTasks);
        return task;
    }

    public Set<TaskDTO> findTaskByPriority(TypesOfTasks typesOfTasks) {
        return this.taskRepository.findByTypesOfTasks(typesOfTasks)
                .stream()
                .map(this::mapTaskDTO)
                .collect(Collectors.toSet());
    }

    private TaskDTO mapTaskDTO(Tasks tasks) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(tasks.getId());
        taskDTO.setTitle(tasks.getTitle());
        taskDTO.setDescription(tasks.getDescription());
        taskDTO.setStartDate(tasks.getStartDate());
        taskDTO.setEndDate(tasks.getEndDate());
        return  taskDTO;
    }


    public Set<TaskDTO> getTaskList(Long id) {
        return this.taskRepository.findAllByUserId(id)
                .stream()
                .map(this::mapTaskDTO)
                .collect(Collectors.toSet());
    }

    public Tasks findTaskById(Long id) {
        return this.taskRepository.findById(id).orElseThrow();
    }
}
