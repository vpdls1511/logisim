package com.logisim.inventory.domain.repository;

import com.logisim.inventory.domain.model.Inventory;

public interface InventoryRepository {
  Inventory save(Inventory inventory);
}
