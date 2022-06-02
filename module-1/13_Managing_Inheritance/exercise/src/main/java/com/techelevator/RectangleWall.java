package com.techelevator;

public class RectangleWall extends Wall{
    //instance variables
    private int length;
    private int height;

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }
    public RectangleWall(String name, String color) {
        super(name, color);

    }
        public int getLength(){
        return length;
    }
    public int getHeight(){
        return height;
    }

    @Override
    public int getArea() {
        int area = getHeight() * getLength();
        return area;
    }
    public String toString(){
        return getName() + " (" + getLength() + "x" + getHeight() + ") rectangle";
    }
}
