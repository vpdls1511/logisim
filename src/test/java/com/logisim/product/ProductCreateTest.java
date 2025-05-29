package com.logisim.product;

import com.google.gson.Gson;
import com.logisim.product.adapter.in.api.ProductController;
import com.logisim.product.adapter.in.api.dto.ProductCreateRequest;
import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.application.usecase.ProductUseCase;
import com.logisim.product.application.validator.ProductValidator;
import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;
import com.logisim.product.exception.DuplicateProductException;
import com.logisim.util.fake.FakeProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Product 등록 테스트")
@ExtendWith(MockitoExtension.class)
public class ProductCreateTest {

  @InjectMocks
  private ProductController controller;
  @Mock
  private ProductUseCase productUseCase;

  MockMvc mockMvc;

  private ProductValidator productValidator;
  private ProductRepository productRepository;


  @BeforeEach
  void setUp() {
    productRepository = new FakeProductRepository();
    productValidator = new ProductValidator(productRepository);

    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  @DisplayName("[Error] 이미 존재하는 이름")
  void productCreateFailWithName() {
    Product product = new Product(null, "개", "시계줄", "이미 존재하는 상품");

    assertThatThrownBy(() -> productValidator.isValid(product))
      .isInstanceOf(DuplicateProductException.class);
  }

  @Test
  @DisplayName("[Success] 등록 가능한 이름")
  void productCreateSuccessWithName() {
    Product product = new Product(null, "개", "모래시계", "등록이 가능한 상품");

    assertThatCode(() -> productValidator.isValid(product))
      .doesNotThrowAnyException();
  }

  @Test
  @DisplayName("컨트롤러 작동 확인용")
  void productCreateSuccess() throws Exception {
    ProductCreateRequest request = new ProductCreateRequest("개", "시게", "테스트 등록 아이템 입니다.");
    ProductCreateCommand requestCommand = request.toCommand();
    doNothing().when(productUseCase).create(requestCommand);

    ResultActions resultActions = mockMvc.perform(
      MockMvcRequestBuilders.post("/product/create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new Gson().toJson(request))
    );

    resultActions.andExpect(status().isOk()).andReturn();
  }
}
