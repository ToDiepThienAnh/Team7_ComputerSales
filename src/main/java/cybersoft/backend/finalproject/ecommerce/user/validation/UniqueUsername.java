package cybersoft.backend.finalproject.ecommerce.user.validation;

import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsEmail;
import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsUsername;
import cybersoft.backend.finalproject.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsername implements ConstraintValidator<ExistsUsername, String> {
    private String message;
    @Autowired
    private UserService userService;

    @Override
    public void initialize(ExistsUsername constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isTakenUsername = userService.isUsernameTaken(value);

        if(!isTakenUsername)
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
