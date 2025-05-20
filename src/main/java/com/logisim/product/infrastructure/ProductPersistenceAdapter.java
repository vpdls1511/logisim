package com.logisim.product.infrastructure;

import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;
import com.logisim.product.infrastructure.persistence.ProductEntity;
import com.logisim.product.infrastructure.persistence.ProductJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import static com.logisim.product.infrastructure.ProductEntityMapper.toDomain;
import static com.logisim.product.infrastructure.ProductEntityMapper.toEntity;

@Component
public class ProductPersistenceAdapter implements ProductRepository {

  private final ProductJpaRepository productJpaRepository;

  public ProductPersistenceAdapter(ProductJpaRepository productJpaRepository) {
    this.productJpaRepository = productJpaRepository;
  }

  @Override
  @Transactional
  public Product save(final Product product) {
    ProductEntity entity = productJpaRepository.save(toEntity(product));
    return toDomain(entity);
  }
}
