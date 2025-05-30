package com.logisim.inventory.domain.model;

import com.logisim.inventory.application.command.InventoryRegisterCommand;

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

  public Long id() {
    return id;
  }

  public Long parent() {
    return parent;
  }

  public Long option1() {
    return option1;
  }

  public Long option2() {
    return option2;
  }

  public Long quantity() {
    return quantity;
  }

  public InventoryRegisterCommand toCommand() {
    return new InventoryRegisterCommand(id, parent, option1, option2);
  }
}
