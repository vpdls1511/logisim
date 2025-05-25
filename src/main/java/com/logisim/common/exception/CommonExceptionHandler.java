package com.logisim.common.exception;

import com.logisim.product.exception.DuplicateProductException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(CommonExceptionHandler.class);

  @ExceptionHandler(DuplicateProductException.class)
  public ResponseEntity<ErrorMessage> duplicateProductException(final DuplicateProductException e) {
    LOG.info("Duplicate product exception = {}", e.getMessage());
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(new ErrorMessage(e.getMessage()));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorMessage> runtimeException(final RuntimeException e) {
    LOG.warn("Runtime exception = {}", e.getMessage());
    return ResponseEntity
      .badRequest()
      .body(new ErrorMessage(e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> exception(final Exception e) {
    LOG.warn("Exception caught in exception = {}", e.getMessage());
    return ResponseEntity
      .badRequest()
      .body(new ErrorMessage(e.getMessage()));
  }


  public record ErrorMessage(String message) { }
}
