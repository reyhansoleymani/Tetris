package com.company.logic.Model;

import com.company.config.Const;
import com.company.logic.Model.Shape.MyShapes;
import com.company.logic.Model.Shape.ShapeModel;

public class GameModel implements IGameModel{

    private ShapeModel newShape;
    private MyShapes myShapes=new MyShapes();
    private boolean shapeReachedBottom = false;
    public boolean newShapeGenerated = false;
    private Const aConst = Const.getInstance();
    private boolean[][] boardCells ;
    private int xc;
    private int yc;

    private int score=0;
    private int[] shapePosition;
    public GameModel() {
        xc=aConst.getXc();
        yc=aConst.getYc();
        boardCells = new boolean[yc][xc];
    }
    public ShapeModel getNewShape() {
        return newShape;
    }
    public void moveRight() {
        int maxX = getMax(getXCoordinates());
        int right = shapePosition[0] + maxX;
        boolean collision = false;
        int[] xs = getXCoordinates();
        int[] ys = getYCoordinates();
        for (int i = 0; i < 4; i++) {
            int x = shapePosition[0] + xs[i];
            int y = shapePosition[1] + ys[i];
            if (x + 1 < xc ) {
                if (boardCells[y][x + 1]) {
                    collision = true;
                    break;
                }
            }
        }
        if (!collision && right < xc- 1) {
            shapePosition[0]++;
        }
    }
    public void moveLeft() {
        int minX = getMin(getXCoordinates());
        int left = shapePosition[0] + minX;
        boolean collision = false;
        int[] xs = getXCoordinates();
        int[] ys = getYCoordinates();
        for (int i = 0; i < 4; i++) {
            int x = shapePosition[0] + xs[i];
            int y = shapePosition[1] + ys[i];
            if (x - 1 >= 0 && boardCells[y][x - 1]) {
                collision = true;
                break;
            }
        }
        if (!collision && left > 0) {
            shapePosition[0]--;
        }
    }
    public void rotate() {
        int oldAngle = newShape.getAngle();
        int newAngle = (oldAngle == 0 ? 3 : oldAngle - 1);
        newShape.setAngle(newAngle);
        int[] xs = getXCoordinates();
        int[] ys = getYCoordinates();
        for (int i = 0; i < 4; i++) {
            int x = shapePosition[0] + xs[i];
            int y = shapePosition[1] + ys[i];
            if (x < 0 || x >= xc || (y <  yc && boardCells[y][x])) {
                newAngle = oldAngle;
                break;
            }
        }
        newShape.setAngle(newAngle);
    }
    public void dropShape() {
        if (newShape == null && !gameOver()) generateNewShape();
        int maxY = getMax(getYCoordinates());
        int bottom = newShape.getShapePosition()[1] + maxY;
        boolean collision = false;
        int[] xs = getXCoordinates();
        int[] ys = getYCoordinates();
        for (int i = 0; i < 4; i++) {
            int x = newShape.getShapePosition()[0] + xs[i];
            int y = newShape.getShapePosition()[1] + ys[i];
            if (y + 1 <  yc) {
                if(boardCells[y + 1][x])
                {
                    collision = true;
                    break;
                }
            }
        }
        checkBotton(bottom,collision,xs,ys);
    }
    private void checkBotton(int bottom,boolean collision,int[] xs,int[] ys) {
        if (bottom <  yc - 1 && !collision) {
            newShape.getShapePosition()[1]++;
        } else {
            for (int i = 0; i < 4; i++) {
                boardCells[newShape.getShapePosition()[1] + ys[i]][newShape.getShapePosition()[0] + xs[i]] = true;
            }
            clearFullLines();
            newShapeGenerated = false;
            if (!gameOver()) {
                generateNewShape();
            }
            else
            {///////////////////////////////////

            }
        }
    }
    public boolean gameOver() {
        for (int j = 0; j < xc; j++) {
            if (boardCells[0][j])
                return true;
        }
        return false;
    }
    private void clearFullLines() {
        int linesCleared = 0;
        for (int i =  yc - 1; i >= 0; i--) {
            boolean full = true;
            for (int j = 0; j < xc; j++) {
                if (!boardCells[i][j]) {
                    full = false;
                    break;
                }
            }
            if (full) {
                linesCleared++;
                for (int k = i; k > 0; k--) {
                    boardCells[k] = boardCells[k - 1].clone();
                }
                boardCells[0] = new boolean[10];
                i++;
            }
        }
        scoreAdd(linesCleared);
    }
    private void scoreAdd(int linesCleared) {
        switch (linesCleared) {
            case 1:
                score += 1;
                break;
            case 2:
                score += 3;
                break;
            case 3:
                score += 5;
                break;
            case 4:
                score += 10;
                break;
        }
    }
    public int[] getXCoordinates() {
        return newShape.getModelX();
    }
    public int[] getYCoordinates() {
        return newShape.getModelY();
    }
    public void generateNewShape() {
        newShape=myShapes.chooseRandomShape();
        shapePosition = newShape.getShapePosition();
        shapeReachedBottom = false;
        int[] xs = getXCoordinates();
        int[] ys = getYCoordinates();
        for (int i = 0; i < 4; i++) {
            int x = shapePosition[0] + xs[i];
            int y = shapePosition[1] + ys[i];
            if (x < 0 || x >= xc || y < 0 || y >= yc || boardCells[y][x]) {
                return;
            }
        }
        newShapeGenerated = true;
    }
    ///////////////////////////////////
    public boolean[][] getBoardCells() {
        return boardCells;
    }
    public boolean isNewShapeGenerated() {
        return newShapeGenerated;
    }
    public int getScore() {
        return score;
    }
    ////////////////////////ye kam koli an nmdonam l=koja bashab
    int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}