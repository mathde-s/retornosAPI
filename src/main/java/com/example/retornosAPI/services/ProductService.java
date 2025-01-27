package com.example.retornosAPI.services;

import com.example.retornosAPI.exceptions.EmptyArgumentException;
import com.example.retornosAPI.exceptions.InvalidArgumentException;
import com.example.retornosAPI.exceptions.ResourceNotFoundException;
import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import com.example.retornosAPI.models.Category;
import com.example.retornosAPI.utills.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity savedEntity = repository.save(entity);
        return ProductMapper.toDTO(savedEntity);
    }

    public Product getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ProductMapper.toDTO(entity);
    }

    public List<Product> getAllProducts() {
        return repository.findAll().stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado.");
        }
        repository.deleteById(id);
    }

    // Atualizar um produto existente
    public Product updateProduct(Long id, Product updatedProduct) {
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("produto com ID " + id + " não encontrado"));

        validateAndUpdateEntity(existingEntity, updatedProduct);
        existingEntity.setName(updatedProduct.name());
        existingEntity.setPrice(updatedProduct.price());
        existingEntity.setCategory(updatedProduct.category());

        ProductEntity savedEntity = repository.save(existingEntity);
        return ProductMapper.toDTO(savedEntity);
    }

    // Buscar produtos pelo nome
    public List<Product> getProductsByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new EmptyArgumentException("O nome do produto não pode ser vazio.");
        }

        List<ProductEntity> entities = repository.findByNameContainingIgnoreCase(name);
        if (entities.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome: " + name);
        } else {
            System.out.println("Produtos encontrados com o nome '" + name + "': " + entities.size());
        }
        return entities.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void validateAndUpdateEntity(ProductEntity existingEntity, Product updatedProduct) {
        if (!Category.isValidEnum(updatedProduct.category().name())) {
            throw new InvalidArgumentException("a categoria não é válida");
        }

        if (updatedProduct.price() < 0) {
            throw new InvalidArgumentException("o preço não pode ser menor que zero.");
        }

        if (updatedProduct.name().length() < 3 || updatedProduct.name().length() > 100) {
            throw new InvalidArgumentException("o nome deve conter entre 3 e 100 caracteres");
        }
    }
}