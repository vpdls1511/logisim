package com.logisim.product.application.service;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.application.usecase.ProductCreateUseCase;
import com.logisim.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductStackingService implements ProductCreateUseCase {

  private final ProductRepository productRepository;

  public ProductStackingService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void create(final ProductCreateCommand command) {
    productRepository.save(command.init());
  }

}
