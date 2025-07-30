package com.company.ui.Panels.Tetris;

import com.company.logic.GameEngine;
import com.company.Controller.GameController;
import com.company.config.Const;
import com.company.logic.Model.IGameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private KeyListener listener;
    private GameEngine engine;
    private IGameModel gameModel;
    private Const aConst = Const.getInstance();

    private int xc;
    private int yc;
    private int xy;

    public GamePanel(GameEngine gameEngine){
        engine = gameEngine;
        setBounds(10,10,aConst.getxReso() - 200,aConst.getyReso());
        xy=aConst.getXY();
        xc=aConst.getXc();
        yc = aConst.getYc();
        setVisible(true);
        setFocusable(true);
        listener = new GameController(engine);
        addKeyListener(listener);
    }
    public void paintComponent(Graphics g) {
        gameModel = engine.getModel();
        setFocusable(true);
        requestFocusInWindow();
        super.paintComponent(g);
        drowLine(g);
        drowNewShapes(g);
        drowShapes(g);
        gameOverCheck(g);
    }

    private void drowShapes(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i <  yc; i++) {
            for (int j = 0; j < xc; j++) {
                if (gameModel.getBoardCells()[i][j]) {
                    g.fill3DRect(j * xy, i * xy, xy - 1, xy - 1, true);
                }
            }
        }
    }

    private void drowNewShapes(Graphics g) {
        if (gameModel.isNewShapeGenerated()) {
            int[] xs = gameModel.getXCoordinates();
            int[] ys = gameModel.getYCoordinates();
            g.setColor(Color.MAGENTA);
            for (int i = 0; i < 4; i++) {
                int x = (gameModel.getNewShape().getShapePosition()[0] + xs[i]) * xy;
                int y = (gameModel.getNewShape().getShapePosition()[1] + ys[i]) * xy;
                g.fill3DRect(x, y, xy-1, xy-1, true);
            }
        }
    }

    private void gameOverCheck(Graphics g) {
        if (gameModel.gameOver()) {
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("Arial", Font.BOLD, aConst.getyReso()/15));
            g.drawString("GAME OVER", 20, 200);
        }
    }

    private void drowLine(Graphics g) {
        g.setColor(Color.BLUE);
        for (int i = 0; i <= xc; i++) {
            g.drawLine(i * xy, 0, i * xy, yc*xy);
        }
        for (int i = 0; i <=  yc ; i++) {
            g.drawLine(0, i * xy, xc*xy, i * xy);
        }
    }
}
