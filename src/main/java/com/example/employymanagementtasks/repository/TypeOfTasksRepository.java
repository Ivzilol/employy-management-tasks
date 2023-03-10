package com.example.employymanagementtasks.repository;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeOfTasksRepository extends JpaRepository<TypesOfTasks, Long> {

    Optional<TypesOfTasks> findByTaskPriority(TaskPriority taskPriority);
}
