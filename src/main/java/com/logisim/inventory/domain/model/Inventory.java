package com.logisim.inventory.domain.model;

public class Inventory {
  private final Long id;
  private final Long parent;
  private final Long option1;
  private final Long option2;
  private final Long quantity;

  public Inventory(Long id, Long parent, Long option1, Long option2, Long quantity) {
    this.id = id;
    this.parent = parent;
    this.option1 = option1;
    this.option2 = option2;
    this.quantity = quantity;
  }
}
