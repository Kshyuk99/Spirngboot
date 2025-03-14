package edu.du.shop.model;

import lombok.Data;

@Data
public class product {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String image;

    public product(Long id, String name, String description, int price, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}
