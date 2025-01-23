package com.example.retornosAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio ou nulo.")
    @Size(min=3, max=100)
    private String name;

    @Max(value = 500, message = "a descrição não pode ter mais de 500 caracteres")
    private String description;

    @Positive(message = "O preço deve ser maior que zero.")
    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Min(value = 0, message = "A quantidade deve ser igual ou maior que zero.")
    private int quantity;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, Double price, Category category, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public ProductEntity(Long id, String name, Double price, Category category, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}