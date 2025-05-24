package com.logisim.product.application.command;

import com.logisim.common.ValidCommand;
import com.logisim.product.domain.model.Product;
import com.logisim.product.adapter.in.api.dto.ProductCreateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductCreateCommand(
  @NotBlank String unit,
  @NotBlank String name,
  @Size(max = 2000) String description
) implements ValidCommand<ProductCreateRequest> {

  public Product init() {
    return new Product(null, unit, name, description);
  }

}
