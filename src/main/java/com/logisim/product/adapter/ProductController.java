package com.logisim.product.adapter;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.application.usecase.ProductUseCase;
import com.logisim.product.adapter.request.ProductCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductUseCase createUseCase;

  public ProductController(ProductUseCase createUseCase) {
    this.createUseCase = createUseCase;
  }

  @PostMapping("/product/create")
  public ResponseEntity<Void> createProduct(
    @RequestBody final ProductCreateRequest request
  ) {
    ProductCreateCommand command = request.toCommand();
    createUseCase.create(command);

    return ResponseEntity.ok().build();
  }
}
