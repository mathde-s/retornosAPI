package com.example.retornosAPI.services;

import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        ProductEntity entity = new ProductEntity(null, product.name(), product.price());
        ProductEntity savedEntity = repository.save(entity);
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice());
    }

    public Product getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new Product(entity.getId(), entity.getName(), entity.getPrice());
    }

    public List<Product> getAllProducts() {
        return repository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}