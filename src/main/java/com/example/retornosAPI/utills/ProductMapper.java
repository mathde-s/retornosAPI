package com.example.retornosAPI.utills;

import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.models.ProductEntity;

public class ProductMapper {
    public static Product toDTO(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getDescription(),
                entity.getPrice(), entity.getCategory(), entity.getQuantity());
    }

    public static ProductEntity toEntity(Product dto) {
        return new ProductEntity(dto.id(), dto.name(), dto.description(),
                dto.price(), dto.category(), dto.quantity());
    }
}
