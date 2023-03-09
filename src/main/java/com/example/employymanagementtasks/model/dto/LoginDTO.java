package com.example.employymanagementtasks.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    private Long id;

    @Size(min = 3, max = 20, message = "Username must be min 3 and max 20 symbols")
    @NotNull
    private String username;
    @Size(min = 3, max = 20, message = "Password must be min 3 and max 20 symbols")
    @NotNull
    private String password;

    public LoginDTO() {
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
}
