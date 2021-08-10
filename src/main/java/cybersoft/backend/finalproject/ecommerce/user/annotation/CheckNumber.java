package cybersoft.backend.finalproject.ecommerce.user.annotation;

import cybersoft.backend.finalproject.ecommerce.user.validation.CheckNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = CheckNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckNumber {
    String message() default "Value must be a number";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
