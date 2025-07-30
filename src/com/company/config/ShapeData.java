package com.company.config;

import java.util.List;

public class ShapeData {
    public String name;
    public List<int[]> rotationsX;
    public List<int[]> rotationsY;

    public ShapeData(String name, List<int[]> rotationsX, List<int[]> rotationsY) {
        this.name = name;
        this.rotationsX = rotationsX;
        this.rotationsY = rotationsY;
    }
    ///error gson bod://?
    public ShapeData() {}
}
