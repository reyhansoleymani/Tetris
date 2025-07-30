package com.company.logic.Model.Shape;

public class ShapeModel {
    private int[][] modelX;
    private int[][] modelY;
    private int[] shapePosition={4,0};
    private String name;
    private int angle=0;
    public ShapeModel (int[][] modelX,int[][] modelY,String name)
    {
        this.name=name;
        this.modelX=modelX;
        this.modelY=modelY;
    }

    public int[] getModelX() {
        return modelX[angle];
    }

    public int[] getModelY() {
        return modelY[angle];
    }
    public int getAngle() {
        return angle;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }
    public int[] getShapePosition() {
        return shapePosition;
    }
    public String getName() {
        return name;
    }
    public void setShapePositionX(int i) {
        shapePosition[0] = i;
    }
    public void setShapePositionY(int i) {
        shapePosition[1] = i;
    }
}
