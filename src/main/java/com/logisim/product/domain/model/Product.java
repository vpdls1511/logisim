package com.logisim.product.domain.model;

public final class Product {
  private final Long id;
  private final String unit;
  private final String name;
  private final String description;

  public Product(Long id, String unit, String name, String description) {
    this.id = id;
    this.unit = unit;
    this.name = name;
    this.description = description;
  }

  public Long id() {
    return id;
  }

  public String unit() {
    return unit;
  }

  public String name() {
    return name;
  }

  public String description() {
    return description;
  }
}
