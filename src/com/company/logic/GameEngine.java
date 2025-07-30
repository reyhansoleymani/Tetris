package com.company.logic;

import com.company.config.Const;
import com.company.logic.Model.GameModel;
import com.company.logic.Model.IGameModel;
import com.company.ui.Panels.Tetris.SidePanel;

import javax.swing.*;

public class GameEngine {
    private IGameModel model;
    private final Timer timer;
    private Const aConst = Const.getInstance();

    public GameEngine() {
        this.model = new GameModel();
        this.timer = new Timer(aConst.getV(), e -> update());
    }
    private void update() {
        if (model.gameOver()){
            timer.stop();
            return;
        }
        model.dropShape();
        aConst.getGamePanel().repaint();
        SidePanel.setLabelScore(model.getScore());
    }
    public void start() {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
    public void reset() {
        timer.stop();
        model = new GameModel();
    }

    public IGameModel getModel() {
        return model;
    }
}
