package com.logisim.inventory.adapter.in.dto;

import com.logisim.inventory.adapter.application.command.InventoryStackingCommand;

public record InventoryStackingRequest(
  Long productId,
  Long coloOptionId,
  Long sizeOptionId,
  Long quantity
) {

  public InventoryStackingCommand toCommand() {
    return new InventoryStackingCommand(productId, coloOptionId, sizeOptionId, quantity);
  }
}
