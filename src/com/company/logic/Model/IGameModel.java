package com.company.logic.Model;

import com.company.logic.Model.Shape.ShapeModel;

public interface IGameModel {
    void moveLeft();
    void moveRight();
    void rotate();
    void dropShape();
    int[] getXCoordinates();
    int[] getYCoordinates();
    ShapeModel getNewShape();
    boolean isNewShapeGenerated();
    void generateNewShape();
    boolean gameOver();
    int getScore();
    boolean[][] getBoardCells();
}