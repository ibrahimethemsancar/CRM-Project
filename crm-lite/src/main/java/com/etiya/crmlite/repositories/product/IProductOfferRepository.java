package com.etiya.crmlite.repositories.product;

import com.etiya.crmlite.entities.concretes.product.ProdOfr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductOfferRepository extends JpaRepository<ProdOfr, Long> {
}
