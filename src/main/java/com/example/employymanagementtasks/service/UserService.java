package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.UserDTO;
import com.example.employymanagementtasks.model.entity.Employees;
import com.example.employymanagementtasks.repository.EmployeeRepository;
import com.example.employymanagementtasks.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class    UserService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;
    private final LoggedUser loggedUser;

    public UserService(EmployeeRepository employeeRepository, PasswordEncoder encoder, LoggedUser loggedUser) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
        this.loggedUser = loggedUser;
    }

    public boolean checkCredential(String username, String password) {
        Employees user = this.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        return encoder.matches(password, user.getPassword());
    }

    private Employees getUserByUsername(String username) {
        return this.employeeRepository.findByUsername(username).orElse(null);
    }

    public void login(String username) {
        Employees user = this.getUserByUsername(username);
        this.loggedUser.setId(user.getId());
        this.loggedUser.setUsername(user.getUsername());
    }

    public UserDTO findUserByUsername(String username) {
        Employees user = this.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        return this.mapUserDTO(user);
    }

    private UserDTO mapUserDTO(Employees user) {
        return new UserDTO()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail());
    }

    public UserDTO findUserByEmail(String email) {
        Employees user = employeeRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return null;
        }
        return this.mapUserDTO(user);
    }
}
