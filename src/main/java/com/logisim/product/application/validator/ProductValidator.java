package com.logisim.product.application.validator;

import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;
import com.logisim.product.exception.DuplicateProductException;

public class ProductValidator {

  private final ProductRepository productRepository;

  public ProductValidator(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void isValid(final Product product) {
    if(productRepository.existByName(product.name())) {
      throw new DuplicateProductException(product.name());
    }
  }
}
