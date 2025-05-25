package com.logisim.product.application.service;

import com.logisim.product.application.command.ProductCreateCommand;
import com.logisim.product.application.port.in.ProductCreateUseCase;
import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService implements ProductCreateUseCase {

  private final ProductRepository productRepository;

  public ProductCreateService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void create(final ProductCreateCommand command) {
      Product product = productRepository.save(command.init());
  }

}
