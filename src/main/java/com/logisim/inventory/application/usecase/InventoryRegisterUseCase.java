package com.logisim.inventory.application.usecase;

import com.logisim.inventory.application.command.InventoryRegisterCommand;
import com.logisim.inventory.domain.model.Inventory;

public interface InventoryRegisterUseCase {
  Inventory registerInventoriesInProduct(InventoryRegisterCommand command) throws RuntimeException;
}
