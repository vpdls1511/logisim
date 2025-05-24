package com.logisim.product.adapter.out.mapper;

import com.logisim.product.domain.model.Product;
import com.logisim.product.adapter.out.persistence.ProductEntity;

public class ProductEntityMapper {

  public static ProductEntity toEntity(final Product product) {
    return new ProductEntity(
      product.unit(),
      product.name(),
      product.description()
    );
  }

  public static Product toDomain(final ProductEntity entity) {
    return new Product(
      entity.getId(),
      entity.getUnit(),
      entity.getName(),
      entity.getDescription()
    );
  }
}
