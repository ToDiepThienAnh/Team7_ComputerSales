package cybersoft.backend.finalproject.ecommerce.user.annotation;

import cybersoft.backend.finalproject.ecommerce.user.validation.UserIdLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserIdLengthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckUserIdLength {
    String message() default "User Id Length must be 9 or 12";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
