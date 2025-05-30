package com.logisim.inventory.adapter.application.usecase;

import com.logisim.inventory.adapter.application.command.InventoryRegisterCommand;
import com.logisim.inventory.domain.model.Inventory;

public interface InventoryRegisterUseCase {
  Inventory registerInventoriesInProduct(InventoryRegisterCommand command) throws RuntimeException;
}
