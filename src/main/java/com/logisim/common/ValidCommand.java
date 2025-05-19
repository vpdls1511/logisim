package com.logisim.common;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

public interface ValidCommand<T> {

  Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  default void validObject(T target) {
    final Set<ConstraintViolation<T>> violations = validator.validate(target);

    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

}
