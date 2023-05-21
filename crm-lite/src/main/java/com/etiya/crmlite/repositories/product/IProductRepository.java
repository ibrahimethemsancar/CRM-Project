package com.etiya.crmlite.repositories.product;

import com.etiya.crmlite.entities.concretes.product.Prod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Prod, Long> {
}
