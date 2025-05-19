package com.logisim.product.infrastructure.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @PostMapping("/inventory/staking")
  public ResponseEntity<Void> stakingInventory() {
    return ResponseEntity.ok().build();
  }
}
