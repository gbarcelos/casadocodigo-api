package br.com.oak.casadocodigoapi.infrastructure.annotation;

import br.com.oak.casadocodigoapi.infrastructure.validator.UniqueValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {

  String message() default "{br.com.oak.casadocodigoapi.annotation.uniqueValue}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String fieldName();

  Class<?> domainClass();
}
