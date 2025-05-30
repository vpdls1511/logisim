package com.logisim.inventory.adapter.out;

import com.logisim.inventory.adapter.out.persistance.InventoryEntity;
import com.logisim.inventory.adapter.out.persistance.InventoryJpaRepository;
import com.logisim.inventory.domain.model.Inventory;
import com.logisim.inventory.domain.repository.InventoryRepository;
import org.springframework.stereotype.Repository;

import static com.logisim.inventory.adapter.out.mapper.InventoryEntityMapper.domainToEntity;

@Repository
public class InventoryRepositoryAdapter implements InventoryRepository {
  private final InventoryJpaRepository inventoryJpaRepository;

  public InventoryRepositoryAdapter(InventoryJpaRepository inventoryJpaRepository) {
    this.inventoryJpaRepository = inventoryJpaRepository;
  }

  @Override
  public Inventory save(final Inventory inventory) {
    InventoryEntity saveInventory = inventoryJpaRepository.save(domainToEntity(inventory));
    return null;
  }
}
