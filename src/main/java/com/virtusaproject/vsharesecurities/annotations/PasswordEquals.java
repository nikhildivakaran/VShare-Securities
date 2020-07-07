package com.virtusaproject.vsharesecurities.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordEqualsValidator.class)
@Documented
public @interface PasswordEquals {
    String message() default "Password doesn't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
