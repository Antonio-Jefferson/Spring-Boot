package com.springBoot.demo.repositories;

import com.springBoot.demo.entities.Category;
import com.springBoot.demo.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
