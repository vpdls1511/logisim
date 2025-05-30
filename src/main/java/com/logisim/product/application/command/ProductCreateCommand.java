package com.logisim.product.application.command;

import com.logisim.common.ValidCommand;
import com.logisim.product.domain.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductCreateCommand(
  @NotBlank String unit,
  @NotBlank String name,
  @Size(max = 2000) String description
) implements ValidCommand<ProductCreateCommand> {

  public ProductCreateCommand(
    final String unit,
    final String name,
    final String description
  ) {
    this.unit = unit;
    this.name = name;
    this.description = description;

    validObject(this);
  }

  public Product init() {
    return new Product(null, unit, name, description);
  }

}
