package com.logisim.product.adapter.request;

import com.logisim.product.application.command.ProductCreateCommand;

public record ProductCreateRequest(
  String unit,
  String name,
  String description
) {
  public ProductCreateCommand toCommand() {
    return new ProductCreateCommand(unit, name, description);
  }
}
