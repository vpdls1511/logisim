package com.logisim.inventory.adapter.out.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class InventoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long parent;
  private Long option1;
  private Long option2;
  private Long quantity;

  public InventoryEntity(final Long id, final Long parent, final Long option1, final Long option2, final Long quantity) {
    this.id = id;
    this.parent = parent;
    this.option1 = option1;
    this.option2 = option2;
    this.quantity = quantity;
  }

  public InventoryEntity() {}

  public Long getId() {
    return id;
  }

  public Long getParent() {
    return parent;
  }

  public Long getOption1() {
    return option1;
  }

  public Long getOption2() {
    return option2;
  }

  public Long getQuantity() {
    return quantity;
  }

}
