package com.virtusaproject.vsharesecurities.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private Pattern pattern;
    private static final String PASSWORD_CRITERIA = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,20}$";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_CRITERIA);
    }

    @Override
    public void initialize(ValidPassword constraintAnnotation) {}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context){
        return password != null && pattern.matcher(password).matches();
    }

}
