package com.example.retornosAPI.repositories;

import com.example.retornosAPI.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Metodo para buscar produtos pelo nome (case insensitive)
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
}