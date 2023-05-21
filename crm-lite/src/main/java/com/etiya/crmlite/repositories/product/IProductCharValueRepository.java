package com.etiya.crmlite.repositories.product;

import com.etiya.crmlite.entities.concretes.product.ProdCharVal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCharValueRepository extends JpaRepository<ProdCharVal, Long> {
}
