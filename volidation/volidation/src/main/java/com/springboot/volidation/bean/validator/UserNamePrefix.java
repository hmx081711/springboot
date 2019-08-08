package com.springboot.volidation.bean.validator;




import com.springboot.volidation.bean.UserNamePrefixConstraintor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {FIELD,METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UserNamePrefixConstraintor.class})
public @interface UserNamePrefix {

    String message() default "{user.name.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String prefix();
}
