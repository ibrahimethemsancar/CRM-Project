package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.BsnInterItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessInteractionItemRepository extends JpaRepository<BsnInterItem, Long> {
}
