package com.company.Controller;

import com.company.config.Const;
import com.company.logic.GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private GameEngine engine;
    private Const aConst =Const.getInstance();
    public GameController(GameEngine engine)
    {
        this.engine = engine;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(aConst.isRotate())engine.getModel().rotate();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            engine.getModel().dropShape();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            engine.getModel().moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            engine.getModel().moveLeft();
        }
        aConst.getGamePanel().repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
