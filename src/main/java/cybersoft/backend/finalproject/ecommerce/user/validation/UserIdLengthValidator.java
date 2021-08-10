package cybersoft.backend.finalproject.ecommerce.user.validation;

import cybersoft.backend.finalproject.ecommerce.user.annotation.CheckUserIdLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdLengthValidator implements ConstraintValidator<CheckUserIdLength, String> {
    private String message;
    @Override
    public void initialize(CheckUserIdLength constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length() == 9 || value.length() == 12)
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
