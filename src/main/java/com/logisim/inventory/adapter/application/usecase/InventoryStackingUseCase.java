package com.logisim.inventory.adapter.application.usecase;

import com.logisim.inventory.adapter.application.command.InventoryStackingCommand;
import com.logisim.inventory.domain.model.Inventory;

public interface InventoryStackingUseCase {
  Inventory stackInventoriesInProduct(InventoryStackingCommand command) throws RuntimeException;
}
