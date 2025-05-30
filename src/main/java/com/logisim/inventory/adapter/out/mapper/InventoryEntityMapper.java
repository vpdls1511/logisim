package com.logisim.inventory.adapter.out.mapper;

import com.logisim.inventory.adapter.out.persistance.InventoryEntity;
import com.logisim.inventory.domain.model.Inventory;

public class InventoryEntityMapper {

  public static InventoryEntity domainToEntity(final Inventory inventory) {
    return new InventoryEntity(
      inventory.id(),
      inventory.parent(),
      inventory.option1(),
      inventory.option2(),
      inventory.quantity()
    );
  }

  public static Inventory entityToDomain(final InventoryEntity entity) {
    return new Inventory(
      entity.getId(),
      entity.getParent(),
      entity.getOption1(),
      entity.getOption2(),
      entity.getQuantity()
    );
  }
}
