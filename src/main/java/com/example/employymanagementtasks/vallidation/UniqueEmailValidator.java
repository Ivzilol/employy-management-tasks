package com.example.employymanagementtasks.vallidation;


import com.example.employymanagementtasks.service.UserService;
import com.example.employymanagementtasks.vallidation.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return this.userService.findUserByEmail(value) == null;
    }
}
