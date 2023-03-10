package com.example.employymanagementtasks.repository;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TypeOfTasksRepository extends JpaRepository<TypesOfTasks, Long> {

    Optional<TypesOfTasks> findTypesOfTasksByTaskPriority(TaskPriority taskPriority);


}
