package cybersoft.backend.finalproject.ecommerce.user.annotation;

import cybersoft.backend.finalproject.ecommerce.user.validation.UniqueEmail;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmail.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsEmail {
    String message() default "Email is exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
