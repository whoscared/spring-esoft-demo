package whoscared.esoftdemo.esoft.demo.utils.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import whoscared.esoftdemo.esoft.demo.utils.validator.PhoneConstraintValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface  Phone {
    String message() default "{Phone}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
