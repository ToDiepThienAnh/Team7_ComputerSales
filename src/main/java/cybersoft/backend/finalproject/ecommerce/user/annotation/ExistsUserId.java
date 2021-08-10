package cybersoft.backend.finalproject.ecommerce.user.annotation;

import cybersoft.backend.finalproject.ecommerce.user.validation.UniqueUserId;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUserId.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsUserId {
    String message() default "User ID is exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
