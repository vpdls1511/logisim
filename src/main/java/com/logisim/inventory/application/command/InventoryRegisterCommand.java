package com.logisim.inventory.application.command;

import com.logisim.common.ValidCommand;
import com.logisim.inventory.domain.model.Inventory;
import jakarta.validation.constraints.NotNull;

public record InventoryRegisterCommand(
  @NotNull Long productId,
  Long coloOptionId,
  Long sizeOptionId,
  @NotNull Long quantity
) implements ValidCommand<InventoryRegisterCommand> {

  public InventoryRegisterCommand(final Long productId, final Long coloOptionId, final Long sizeOptionId, final Long quantity) {
    this.productId = productId;
    this.coloOptionId = coloOptionId;
    this.sizeOptionId = sizeOptionId;
    this.quantity = quantity;

    validObject(this);
  }

  public Inventory init() {
    return new Inventory(null, this.productId, this.coloOptionId, this.sizeOptionId, this.quantity);
  }
}
