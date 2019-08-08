package com.springboot.volidation.bean;

import com.springboot.volidation.bean.validator.UserNamePrefix;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 @author  <a href="http://2283098554@qq.com">huangmingxin</a>
 @see
 @since
 @create 2019/8/5
*/
public class UserNamePrefixConstraintor implements ConstraintValidator<UserNamePrefix, String> {
    private String prefix;

    @Override
    public void initialize(UserNamePrefix constraintAnnotation) {
        this.prefix = constraintAnnotation.prefix();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (!name.startsWith(prefix)){
            context.disableDefaultConstraintViolation();
            ConstraintValidatorContext.ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate("user's name must be named by" + prefix + "!");
            builder.addConstraintViolation();
            return false;
        }
        return true;
    }
}
