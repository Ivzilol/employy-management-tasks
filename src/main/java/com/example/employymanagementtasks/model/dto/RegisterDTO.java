package com.example.employymanagementtasks.model.dto;

import com.example.employymanagementtasks.vallidation.annotation.UniqueEmail;
import com.example.employymanagementtasks.vallidation.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class RegisterDTO {

    private Long id;

    @UniqueUsername
    @Size(min = 3, max = 20, message = "Username must be min 3 and max 20 symbols")
    @NotNull
    private String username;

    @NotNull
    @Size(min = 3, max = 20, message = "Username must be min 3 and max 20 symbols")
    private String password;

    @NotNull
    @Size(min = 3, max = 20, message = "Username must be min 3 and max 20 symbols")
    private String confirmPassword;

    @NotNull
    private String fullName;

    @NotNull
    private BigDecimal salary;

    @NotNull
    private int phoneNumber;

    @UniqueEmail
    @Email
    @NotBlank
    private String email;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    public RegisterDTO() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
