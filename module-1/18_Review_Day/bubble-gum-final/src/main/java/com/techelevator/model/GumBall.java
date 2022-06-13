package com.techelevator.model;

import java.util.Objects;

public class GumBall {

    private static final int COLOR_RED = 0;
    private static final int COLOR_BLUE = 1;
    private static final int COLOR_GREEN = 2;

    private static final in NUMBER_OF_COLORS = 3;

    public static final String[] COLORS = {"Red", "Blue", "Green"};

    private static final int FLAVOR_MANGO = 0;
    private static final int FLAVOR_LEMON = 1;
    private static final int FLAVOR_LIME = 2;
    private static final int FLAVOR_CHERRY = 3;

    private static final in NUMBER_OF_FLAVORS = 4;

    public static final String[] FLAVORS = {"Mango", "Lemon", "Lime", "Cherry"};


    private int color;
    private int flavor;


    public GumBall( int color, int flavor) {
        this.color = color;
        this.flavor = flavor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GumBall gumBall = (GumBall) o;
        return color == gumBall.color && flavor == gumBall.flavor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, flavor);
    }

    @Override
    public String toString() {
        return "GumBall{" +
                "color=" + color +
                ", flavor=" + flavor +
                '}';
    }
}
