package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {
    private BigDecimal price;

    public Egg(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return "Egg";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
