package cybersoft.backend.finalproject.ecommerce.user.validation;

import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsUserId;
import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsUsername;
import cybersoft.backend.finalproject.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserId implements ConstraintValidator<ExistsUserId, String> {
    private String message;
    @Autowired
    private UserService userService;

    @Override
    public void initialize(ExistsUserId constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isTakenUserId = userService.isUserIdTaken(value);

        if(!isTakenUserId)
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
