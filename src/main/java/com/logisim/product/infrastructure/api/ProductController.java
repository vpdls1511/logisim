package com.logisim.product.infrastructure.api;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.infrastructure.api.dto.ProductCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @PostMapping("/product/create")
  public ResponseEntity<Void> createProduct() {
    return ResponseEntity.ok().build();
  }

  @PostMapping("/product/staking")
  public ResponseEntity<Void> stakingProduct(
    @RequestBody final ProductCreateRequest request
    ) {
    ProductCreateCommand command = request.toCommand();
    return ResponseEntity.ok().build();
  }
}
