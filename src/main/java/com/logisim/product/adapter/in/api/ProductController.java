package com.logisim.product.adapter.in.api;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.application.port.in.ProductCreateUseCase;
import com.logisim.product.adapter.in.api.dto.ProductCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductCreateUseCase createUseCase;

  public ProductController(ProductCreateUseCase createUseCase) {
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

  @PostMapping("/product/staking")
  public ResponseEntity<Void> stakingProduct() {
    return ResponseEntity.ok().build();
  }
}
