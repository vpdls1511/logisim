package com.logisim.util.fake;

import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;

public class FakeProductRepository implements ProductRepository {

  @Override
  public Product save(Product product) {
    return null;
  }

  @Override
  public boolean existByName(String name) {
    return name.contains("시계줄");
  }

}
