package com.logisim.inventory.adapter.in;

import com.logisim.inventory.adapter.application.command.InventoryStackingCommand;
import com.logisim.inventory.adapter.application.usecase.InventoryStackingUseCase;
import com.logisim.inventory.adapter.in.dto.InventoryStackingResponse;
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

  private final InventoryStackingUseCase inventoryStackingUseCase;

  public InventoryController(final InventoryStackingUseCase inventoryStackingUseCase) {
    this.inventoryStackingUseCase = inventoryStackingUseCase;
  }

  @PostMapping
  public ResponseEntity<InventoryStackingResponse> register(@RequestBody final Inventory inventory) {
    InventoryStackingCommand command = inventory.toCommand();
    Inventory request = inventoryStackingUseCase.stackInventoriesInProduct(command);

    return ResponseEntity.created(URI.create("/inventory"))
      .body(new InventoryStackingResponse(request.id()));
  }
}
