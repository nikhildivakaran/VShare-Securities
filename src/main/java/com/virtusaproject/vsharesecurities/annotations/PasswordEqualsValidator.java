package com.virtusaproject.vsharesecurities.annotations;

import com.virtusaproject.vsharesecurities.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordEqualsValidator implements ConstraintValidator<PasswordEquals, UserDto> {
    @Override
    public void initialize(PasswordEquals constraintAnnotation) {}

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getConfirmPassword().equals(userDto.getPassword());
    }
}
