package com.logisim.inventory.application.service;

import com.logisim.common.exception.NotCreatedException;
import com.logisim.inventory.application.command.InventoryRegisterCommand;
import com.logisim.inventory.application.usecase.InventoryRegisterUseCase;
import com.logisim.inventory.domain.model.Inventory;
import com.logisim.inventory.domain.repository.InventoryRepository;
import com.logisim.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryStackingService implements InventoryRegisterUseCase {

  private static final String NOT_CREATED_EXCEPTION_MESSAGE = "생성에 실패하였습니다.";

  private final ProductRepository productRepository;
  private final InventoryRepository inventoryRepository;

  public InventoryStackingService(
    final ProductRepository productRepository,
    final InventoryRepository inventoryRepository
  ) {
    this.productRepository = productRepository;
    this.inventoryRepository = inventoryRepository;
  }

  @Override
  @Transactional
  public Inventory registerInventoriesInProduct(final InventoryRegisterCommand command) throws RuntimeException {
    if (!productRepository.existById(command.productId())) {
      throw new NotCreatedException(NOT_CREATED_EXCEPTION_MESSAGE);
    }

    return inventoryRepository.save(command.init());
  }
}
