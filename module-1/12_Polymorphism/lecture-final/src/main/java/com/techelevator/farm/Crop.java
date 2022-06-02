package com.techelevator.farm;

import java.math.BigDecimal;

public class Crop implements Sellable {
    private String name;
    private BigDecimal price;


    public Crop(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
