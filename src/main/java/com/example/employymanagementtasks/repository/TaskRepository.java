package com.example.employymanagementtasks.repository;

import com.example.employymanagementtasks.model.dto.TaskDTO;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.model.entity.TypesOfTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {


    Set<Tasks> findByTypesOfTasks(TypesOfTasks typesOfTasks);

    @Query("select s, u from Tasks s join s.employees u on u.id = :id")
    Set<Tasks> findAllByUserId(Long id);

}
