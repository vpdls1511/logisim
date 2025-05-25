package com.logisim.product.exception;

public class DuplicateProductException extends RuntimeException {

  public static final String EXCEPTION_MESSAGE = "%s는 이미 등록된 상품 명 입니다.";


  public DuplicateProductException(final String name) {
    super(String.format(EXCEPTION_MESSAGE, name));
  }

}
