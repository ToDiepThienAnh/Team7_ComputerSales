package cybersoft.backend.finalproject.ecommerce.user.validation;

import cybersoft.backend.finalproject.ecommerce.user.annotation.ConfirmPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, Object> {
    private String message;
    private String getPassword;
    private String getConfirmPassword;

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.getPassword = constraintAnnotation.getConfirmPassword();
        this.getConfirmPassword = constraintAnnotation.getPassword();
    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext context) {
        try {
            String password = (String)target.getClass().getMethod(getPassword).invoke(target);
            String confirmPassword = (String)target.getClass().getMethod(getConfirmPassword).invoke(target);
            if (password.equals(confirmPassword))
                return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
