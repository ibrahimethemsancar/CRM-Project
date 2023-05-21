package com.etiya.crmlite.repositories.product;

import com.etiya.crmlite.entities.concretes.product.ProdSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductSpecificationRepository extends JpaRepository<ProdSpec, Long> {
}
