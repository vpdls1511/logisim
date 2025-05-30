package com.logisim.product.infrastructure;

import com.logisim.product.domain.model.Product;
import com.logisim.product.domain.repository.ProductRepository;
import com.logisim.product.infrastructure.persistence.ProductEntity;
import com.logisim.product.infrastructure.persistence.ProductJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import static com.logisim.product.infrastructure.mapper.ProductEntityMapper.toDomain;
import static com.logisim.product.infrastructure.mapper.ProductEntityMapper.toEntity;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

  private final ProductJpaRepository productJpaRepository;

  public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
    this.productJpaRepository = productJpaRepository;
  }

  @Override
  @Transactional
  public Product save(final Product product) {
    ProductEntity entity = productJpaRepository.save(toEntity(product));
    return toDomain(entity);
  }

  @Override
  public boolean existByName(final String name) {
    return !productJpaRepository.findByName(name).isEmpty();
  }

  @Override
  public boolean existById(Long id) {
    return productJpaRepository.findById(id).isPresent();
  }

}
