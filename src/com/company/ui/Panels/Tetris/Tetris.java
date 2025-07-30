package com.company.ui.Panels.Tetris;

import com.company.logic.GameEngine;
import com.company.config.Const;

import javax.swing.*;

public class Tetris extends JPanel {
    private final GamePanel gamePanel;
    private final SidePanel sidePanel;
    private Const aConst = Const.getInstance();
    public Tetris(){
        setSize(aConst.getxReso(), aConst.getyReso());
        setLayout(null);
        GameEngine gameEngine = new GameEngine();
        gamePanel = new GamePanel(gameEngine);
        add(gamePanel);
        sidePanel =new SidePanel(gameEngine);
        add(sidePanel);
        aConst.setGamePanel(gamePanel);
        setVisible(true);
    }
}
