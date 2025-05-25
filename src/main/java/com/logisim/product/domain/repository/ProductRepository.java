package com.logisim.product.domain.repository;

import com.logisim.product.domain.model.Product;

public interface ProductRepository {
  Product save(Product product);
  boolean existByName(String name);
}
