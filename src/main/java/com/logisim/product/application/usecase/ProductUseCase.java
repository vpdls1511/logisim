package com.logisim.product.application.usecase;

import com.logisim.product.application.command.ProductCreateCommand;

public interface ProductUseCase {
  void create(ProductCreateCommand command);
}
