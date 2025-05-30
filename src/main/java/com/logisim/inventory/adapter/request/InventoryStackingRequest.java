package com.logisim.inventory.adapter.request;

import com.logisim.inventory.application.command.InventoryRegisterCommand;

public record InventoryStackingRequest(
  Long productId,
  Long coloOptionId,
  Long sizeOptionId,
  Long quantity
) {

  public InventoryRegisterCommand toCommand() {
    return new InventoryRegisterCommand(productId, coloOptionId, sizeOptionId, quantity);
  }
}
