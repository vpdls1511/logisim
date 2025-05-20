package com.logisim.product.infrastructure.persistence;

import com.logisim.common.persistence.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String unit;
  private String name;
  private String description;

  public ProductEntity() {}

  public ProductEntity(String unit, String name, String description) {
    this.unit = unit;
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public String getUnit() {
    return this.unit;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }
}
