package com.example.employymanagementtasks.service;

import com.example.employymanagementtasks.model.dto.RegisterDTO;
import com.example.employymanagementtasks.model.dto.UserDTO;
import com.example.employymanagementtasks.model.entity.Employees;
import com.example.employymanagementtasks.model.entity.Tasks;
import com.example.employymanagementtasks.repository.EmployeeRepository;
import com.example.employymanagementtasks.util.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;
    private final LoggedUser loggedUser;

    private final HttpSession httpSession;

    public UserService(EmployeeRepository employeeRepository, PasswordEncoder encoder, LoggedUser loggedUser, HttpSession httpSession) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
        this.loggedUser = loggedUser;
        this.httpSession = httpSession;
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

    public void register(RegisterDTO registerDTO) {
        this.employeeRepository.save(this.mapUser(registerDTO));
        this.login(registerDTO.getUsername());
    }

    private Employees mapUser(RegisterDTO registerDTO) {
        Employees user = new Employees();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        user.setSalary(registerDTO.getSalary());
        user.setFullName(registerDTO.getFullName());
        user.setBirthDate(registerDTO.getBirthDate());
        user.setPhoneNumber(registerDTO.getPhoneNumber());

        return user;
    }

    public void logout() {
        this.httpSession.invalidate();
        this.loggedUser.setUsername(null);
        this.loggedUser.setId(null);
    }

    public void addTaskToUser(Long userId, Tasks task) {
        Employees user = this.getUserById(userId);
        if (user.getTasks().stream().noneMatch(t -> t.getId().equals(task.getId()))) {
            user.addTaskToTaskList(task);
            this.employeeRepository.save(user);
        }
    }

    private Employees getUserById(Long userId) {
        return this.employeeRepository.findById(userId).orElseThrow();
    }

    public void removeTaskFromUser(Long taskId, Long userId) {
        Employees user = getUserById(userId);
        user.removeTaskFromTaskList(taskId);
        this.employeeRepository.save(user);
    }

    public void deleteAllTasks(Long userId) {
        Employees user = getUserById(userId);
        user.deleteAllTaskFromTaskList();
        this.employeeRepository.save(user);
    }
}
