package com.example.employymanagementtasks.repository;

import com.example.employymanagementtasks.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    Optional<Employees> findByUsername(String username);

    Optional<Employees> findByEmail(String email);
}
