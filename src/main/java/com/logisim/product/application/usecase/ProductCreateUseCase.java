package com.logisim.product.application.usecase;

import com.logisim.product.application.command.ProductCreateCommand;

public interface ProductCreateUseCase {
  void create(ProductCreateCommand command);
}
