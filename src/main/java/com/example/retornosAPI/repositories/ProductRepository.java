package com.example.retornosAPI.repositories;

import com.example.retornosAPI.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}