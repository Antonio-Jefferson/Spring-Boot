package com.springBoot.demo.repositories;

import com.springBoot.demo.entities.Category;
import com.springBoot.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
