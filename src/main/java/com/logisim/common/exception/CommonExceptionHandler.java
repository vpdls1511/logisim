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

  private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

  @ExceptionHandler(NotCreatedException.class)
  public ResponseEntity<ErrorMessage> notCreatedException(NotCreatedException e) {
    logger.warn(e.getMessage());
    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(new ErrorMessage(e.getMessage()));
  }

  @ExceptionHandler(DuplicateProductException.class)
  public ResponseEntity<ErrorMessage> duplicateProductException(final DuplicateProductException e) {
    logger.info("Duplicate product exception = {}", e.getMessage());
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(new ErrorMessage(e.getMessage()));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorMessage> runtimeException(final RuntimeException e) {
    logger.warn("Runtime exception = {}", e.getMessage());
    return ResponseEntity
      .badRequest()
      .body(new ErrorMessage(e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> exception(final Exception e) {
    logger.warn("Exception caught in exception = {}", e.getMessage());
    return ResponseEntity
      .badRequest()
      .body(new ErrorMessage(e.getMessage()));
  }


  public record ErrorMessage(String message) { }
}
