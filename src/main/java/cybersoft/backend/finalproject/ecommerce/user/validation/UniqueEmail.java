package cybersoft.backend.finalproject.ecommerce.user.validation;

import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsEmail;
import cybersoft.backend.finalproject.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmail implements ConstraintValidator<ExistsEmail, String> {
    private String message;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(ExistsEmail constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isTakenEmail = userService.isEmailTaken(value);

        if(!isTakenEmail)
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
