package com.logisim.product;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.adapter.in.api.dto.ProductCreateRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@DisplayName("Product Command 생성 테스트")
public class ProductCommandTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }


  @Test
  @DisplayName("[FAIL] name 공백 테스트")
  void toCommandNameFail() {
    //given
    String unit = "개";
    String name = "";
    String description  = "2000자넘기는 테스트도 해보고싶은데 이거너무길다 ㅎㅎ..";
    ProductCreateRequest request = new ProductCreateRequest(unit, name, description);

    //when
    Throwable throwable = catchThrowable(() -> validator.validate(request.toCommand()));

    //then
    assertThat(throwable)
      .isInstanceOf(ConstraintViolationException.class)
      .hasMessageContaining("name");
  }


  @Test
  @DisplayName("[FAIL] name 공백 테스트")
  void toCommandUnitFail() {
    // given
    String unit = "";
    String name = "이 상품은 테스트 상품 입니다.";
    String description  = "2000자넘기는 테스트도 해보고싶은데 이거너무길다 ㅎㅎ..";
    ProductCreateRequest request = new ProductCreateRequest(unit, name, description);

    //when
    Throwable throwable = catchThrowable(() -> validator.validate(request.toCommand()));

    assertThat(throwable)
      .isInstanceOf(ConstraintViolationException.class)
      .hasMessageContaining("unit");
  }


  @Test
  @DisplayName("[SUCCESS] Dto 에서 Command로 변환")
  void toCommandSuccess() {
    String unit = "개";
    String name = "이 상품은 테스트 상품 입니다.";
    String description  = "2000자넘기는 테스트도 해보고싶은데 이거너무길다 ㅎㅎ..";

    ProductCreateRequest request = new ProductCreateRequest(unit, name, description);

    Set<ConstraintViolation<ProductCreateCommand>> violations = validator.validate(request.toCommand());

    assertThat(violations).isEmpty();
  }
}
