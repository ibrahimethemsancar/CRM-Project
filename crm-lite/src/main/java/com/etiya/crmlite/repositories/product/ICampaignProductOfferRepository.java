package com.etiya.crmlite.repositories.product;

import com.etiya.crmlite.entities.concretes.product.CmpgProdOfr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICampaignProductOfferRepository extends JpaRepository<CmpgProdOfr, Long> {
}
