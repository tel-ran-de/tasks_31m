package de.telran.surf.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {

    private String id;

    private String name;

    private double price;

    private double oldPrice;

    private boolean isNew;

    private boolean isHot;

    private String picture;

    private String description;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }
}
