package com.company.logic.Model.Shape;

import com.company.config.Const;
import com.company.config.ShapeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyShapes {

    public List<ShapeModel> myShapes;

    public MyShapes()
    {
        myShapes=new ArrayList<>();
        for (ShapeData data : Const.getInstance().getShapeDataList()) {
            int[][] x = new int[4][4];
            int[][] y = new int[4][4];
            for (int i = 0; i < 4; i++) {
                x[i] = data.rotationsX.get(i);
                y[i] = data.rotationsY.get(i);
            }
            myShapes.add(new ShapeModel(x, y, data.name));
        }


    }
    public void addShape(int[] x, int[] y , String name){

        ShapeData newData = new ShapeData(name, Arrays.asList(x,x,x,x), Arrays.asList(y,y,y,y));
        Const.getInstance().getShapeDataList().add(newData);
        int[][] xs = new int[4][4];
        int[][] ys = new int[4][4];
        for (int i = 0; i < 4; i++) {
            xs[i] = newData.rotationsX.get(i);
            ys[i] = newData.rotationsY.get(i);
        }
        myShapes.add(new ShapeModel(xs,ys,name));
    }
    private int angle=0;
    public ShapeModel chooseRandomShape()
    {
        angle = new Random().nextInt(4);
        ShapeModel newshape= myShapes.get(new Random().nextInt(myShapes.size() - 1));
        newshape.setShapePositionX(4);
        newshape.setShapePositionY(0);
        return newshape;
    }

}
