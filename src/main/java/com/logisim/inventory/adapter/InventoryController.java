package com.logisim.inventory.adapter;

import com.logisim.inventory.application.command.InventoryRegisterCommand;
import com.logisim.inventory.application.usecase.InventoryRegisterUseCase;
import com.logisim.inventory.adapter.response.InventoryRegisterResponse;
import com.logisim.inventory.domain.model.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

  private final InventoryRegisterUseCase inventoryRegisterUseCase;

  public InventoryController(final InventoryRegisterUseCase inventoryRegisterUseCase) {
    this.inventoryRegisterUseCase = inventoryRegisterUseCase;
  }

  @PostMapping
  public ResponseEntity<InventoryRegisterResponse> register(@RequestBody final Inventory inventory) {
    InventoryRegisterCommand command = inventory.toCommand();
    Inventory request = inventoryRegisterUseCase.registerInventoriesInProduct(command);

    return ResponseEntity.created(URI.create("/inventory"))
      .body(new InventoryRegisterResponse(request.id()));
  }
}
