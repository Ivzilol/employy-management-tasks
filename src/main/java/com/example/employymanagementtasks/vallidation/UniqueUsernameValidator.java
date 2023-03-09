package com.example.employymanagementtasks.vallidation;

import com.example.employymanagementtasks.service.UserService;
import com.example.employymanagementtasks.vallidation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return this.userService.findUserByUsername(value) == null;
    }
}
