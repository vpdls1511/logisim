package com.logisim.product.adapter.in.api.dto;

import com.logisim.product.application.command.ProductCreateCommand;

public class ProductCreateRequest {
  final private String unit;
  final private String name;
  final private String description;

  public ProductCreateRequest(
    final String unit,
    final String name,
    final String description
  ) {
    this.unit = unit;
    this.name = name;
    this.description = description;
  }

  public ProductCreateCommand toCommand() {
    return new ProductCreateCommand(unit, name, description);
  }
}
