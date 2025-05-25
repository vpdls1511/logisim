package com.logisim.product;

import com.logisim.product.application.validator.ProductValidator;
import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;
import com.logisim.product.exception.DuplicateProductException;
import com.logisim.util.fake.FakeProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("Product 등록 테스트")
public class ProductCreateTest {

  private ProductValidator productValidator;
  private ProductRepository productRepository;


  @BeforeEach
  void setUp() {
    productRepository = new FakeProductRepository();
    productValidator = new ProductValidator(productRepository);
  }

  @Test
  @DisplayName("[Error] 이미 존재하는 이름")
  void productCreateFail() {
    Product product = new Product(null, "개", "시계줄", "이미 존재하는 상품");

    assertThatThrownBy(() -> productValidator.isValid(product))
      .isInstanceOf(DuplicateProductException.class);
  }

  @Test
  @DisplayName("[Success] 등록 가능한 이름")
  void productCreateSuccess() {
    Product product = new Product(null, "개", "모래시계", "등록이 가능한 상품");

    assertThatCode(() -> productValidator.isValid(product))
      .doesNotThrowAnyException();
  }
}
