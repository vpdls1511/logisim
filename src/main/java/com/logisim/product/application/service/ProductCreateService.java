package com.logisim.product.application.service;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.application.usecase.ProductUseCase;
import com.logisim.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCreateService implements ProductUseCase {

  private final ProductRepository productRepository;

  public ProductCreateService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public void create(final ProductCreateCommand command) {
      productRepository.save(command.init());
  }

}
