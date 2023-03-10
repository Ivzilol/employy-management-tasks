package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.AddTaskDTO;
import com.example.employymanagementtasks.model.dto.TaskDTO;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

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
        task.setDescription(addTaskDTO.getDescription());
        task.setTitle(addTaskDTO.getTitle());
        task.setStartDate(addTaskDTO.getStartDate());
        task.setEndDate(addTaskDTO.getEndDate());
        return task;
    }

//    public Set<TaskDTO> findTaskByPriority() {
//        return this.taskRepository.findTasksByTaskPriority()
//                .stream()
//                .map(this::mapTaskDTO)
//                .collect(Collectors.toList());
//    }
//
//    private TaskDTO mapTaskDTO(Tasks task) {
//        TaskDTO taskDTO = new TaskDTO();
//        taskDTO.setId(task.getId());
//        taskDTO.setDescription(task.getDescription());
//        taskDTO.setTitle(task.getTitle());
//        taskDTO.setStartDate(task.getStartDate());
//        taskDTO.setEndDate(task.getEndDate());
//        return taskDTO;
//    }
}
