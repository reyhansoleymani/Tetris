package com.company.config;

import com.company.ui.Panels.Tetris.GamePanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Const {
    private static Const instance = new Const();
    public static Const getInstance(){
        return instance;
    }


    public void copyFrom(Const other) {
        this.v = other.v;
        this.rotate = other.rotate;
        this.xReso = other.xReso;
        this.yReso = other.yReso;
        this.shapeDataList=other.shapeDataList;
    }
//
    private List<ShapeData> shapeDataList = new ArrayList<>();
    public List<ShapeData> getShapeDataList() {
        return shapeDataList;
    }
    public void setShapeDataList(List<ShapeData> shapeDataList) {
        this.shapeDataList = shapeDataList;
    }
    public void loadDefaultShapes() {
        shapeDataList.clear();
        shapeDataList.add(new ShapeData("L",
                Arrays.asList(new int[]{1, 0, 0, 0}, new int[]{0, 1, 2, 2}, new int[]{1, 1, 1, 0}, new int[]{0, 0, 1, 2}),
                Arrays.asList(new int[]{2, 2, 1, 0}, new int[]{1, 1, 1, 0}, new int[]{2, 1, 0, 0}, new int[]{1, 0, 0, 0})
        ));
        shapeDataList.add(new ShapeData("S",
                Arrays.asList(new int[]{0, 1, 1, 2}, new int[]{1, 1, 0, 0}, new int[]{0, 1, 1, 2}, new int[]{1, 1, 0, 0}),
                Arrays.asList(new int[]{1, 1, 0, 0}, new int[]{2, 1, 1, 0}, new int[]{1, 1, 0, 0}, new int[]{2, 1, 1, 0})
        ));
        shapeDataList.add(new ShapeData("Z",
                Arrays.asList(new int[]{2, 1, 1, 0},new int[] {1, 1, 0, 0},new int[] {2, 1, 1, 0},new int[] {1, 1, 0, 0}),
                Arrays.asList(new int[]{1, 1, 0, 0},new int[] {0, 1, 1, 2},new int[] {1, 1, 0, 0}, new int[]{0, 1, 1, 2})
        ));
        shapeDataList.add(new ShapeData("RL",
                Arrays.asList(new int[]{0, 1, 1, 1}, new int[]{2, 2, 1, 0}, new int[]{0, 0, 0, 1},new int[] {2, 1, 0, 0}),
                Arrays.asList(new int[]{2, 2, 1, 0}, new int[]{1, 0, 0, 0},new int[] {2, 1, 0, 0}, new int[]{1, 1, 1, 0})
        ));
        shapeDataList.add(new ShapeData("T",
                Arrays.asList(new int[]{1, 2, 1, 0}, new int[]{0, 0, 0, 1},new int[] {2, 1, 0, 1},new int[] {1, 1, 1, 0}),
                Arrays.asList(new int[]{1, 0, 0, 0}, new int[]{2, 1, 0, 1},new int[] {1, 1, 1, 0},new int[] {2, 1, 0, 1})
        ));
        shapeDataList.add(new ShapeData("SQ",
                Arrays.asList(new int[]{1, 0, 1, 0},new int[] {1, 0, 1, 0}, new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0}),
                Arrays.asList(new int[]{1, 1, 0, 0},new int[] {1, 1, 0, 0}, new int[]{1, 1, 0, 0}, new int[]{1, 1, 0, 0})
        ));
        shapeDataList.add(new ShapeData("I",
                Arrays.asList(new int[]{0, 0, 0, 0}, new int[]{0, 1, 2, 3},new int[] {0, 0, 0, 0}, new int[]{0, 1, 2, 3}),
                Arrays.asList(new int[]{3, 2, 1, 0}, new int[]{0, 0, 0, 0}, new int[]{3, 2, 1, 0}, new int[]{0, 0, 0, 0})
        ));

    }
    ////////////////
    private int v=300;
    private boolean rotate=true;
    private int xReso=430;
    private int yReso =450;



    public void setxReso(int xReso) {
        this.xReso = xReso;
    }
    public int getxReso() {
        return xReso;
    }
    public void setyReso(int yReso) {
        this.yReso = yReso;
    }
    public int getyReso() {
        return yReso;
    }
    public void setRotate(boolean rotate) {
        this.rotate = rotate;
    }
    public boolean isRotate() {
        return rotate;
    }
    public void setV(int v) {
        this.v = v;
    }
    public int getV() {
        return v;
    }


    ///serfa bray dastresi:)
    private transient  GamePanel gamePanel;
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    //////serfabray mohasebe
    public int getXY() {
        int xy = Math.min((yReso-50)/15 , (xReso-210) / 10);
        return xy;
    }
    public int getXc() {
        int xy = Math.min((yReso-50)/15 , (xReso-210) / 10);
        int xc=(xReso-210) /xy;
        return xc;
    }
    public int getYc() {
        int xy = Math.min((yReso-50)/15 , (xReso-210) / 10);
        int yc=(yReso-50)/xy;
        return yc;
    }
}
