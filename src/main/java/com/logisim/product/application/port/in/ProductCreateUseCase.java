package com.logisim.product.application.port.in;

import com.logisim.product.application.command.ProductCreateCommand;

public interface ProductCreateUseCase {
  void create(ProductCreateCommand command);
}
