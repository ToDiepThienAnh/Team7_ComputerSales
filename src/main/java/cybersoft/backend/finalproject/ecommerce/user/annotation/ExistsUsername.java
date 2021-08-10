package cybersoft.backend.finalproject.ecommerce.user.annotation;

import cybersoft.backend.finalproject.ecommerce.user.validation.UniqueUsername;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUsername.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsUsername {
    String message() default "Username is exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
