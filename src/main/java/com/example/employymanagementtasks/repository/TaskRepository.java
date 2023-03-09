package com.example.employymanagementtasks.repository;

import com.example.employymanagementtasks.model.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {

}
