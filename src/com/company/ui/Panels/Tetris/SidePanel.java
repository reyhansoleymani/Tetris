package com.company.ui.Panels.Tetris;


import com.company.logic.GameEngine;
import com.company.Controller.PanelController.SideController;
import com.company.config.Const;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SidePanel extends JPanel {
    private static JLabel labelScoreUpdateLocal;
    private  JLabel labelScore;
    private JButton startButton;
    private JButton pauseButton;
    private JButton back;
    private SideController controller;
    private Const aConst = Const.getInstance();


    public SidePanel(GameEngine gameEngine){
        controller = new SideController(gameEngine);
        setVisible(true);
        setLayout(null);
        setBounds(aConst.getxReso() -190, 0, 180 , aConst.getyReso());
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE),
                "", TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Arial", Font.PLAIN, 12),
                Color.WHITE));
        setBackground(new Color(0, 0, 50));


        makeLabelScore();
        makePause();
        makeStart();
        makeBack();
        makeScoreUpdate();
    }

    public static void setLabelScore(int score) {

        labelScoreUpdateLocal.setText(String.valueOf(score));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    private void makePause() {
        pauseButton = new JButton();
        pauseButton.setText("Pause");
        pauseButton.setBounds(100, 120, 70, 30);

        pauseButton.addActionListener(e -> {
            controller.pauseClick(pauseButton);
        });
        add(pauseButton);
    }
    private void makeStart() {
        startButton = new JButton();
        startButton.setText("Start");
        startButton.setBounds(20, 120, 70, 30);

        startButton.addActionListener(e -> {
            controller.startClick(startButton);
        });
        add(startButton);
    }
    private void makeBack() {
        back = new JButton();
        back.setText("Back");
        back.setBounds(60, 200, 70, 30);
        back.addActionListener(e -> {
            controller.backClick();
        });
        add(back);
    }
    private void makeScoreUpdate() {
        labelScoreUpdateLocal = new JLabel("0", SwingConstants.CENTER);
        labelScoreUpdateLocal.setOpaque(true);
        labelScoreUpdateLocal.setBackground(new Color(150, 150, 255));
        labelScoreUpdateLocal.setFont(new Font("Arial", Font.BOLD, 10));
        labelScoreUpdateLocal.setBounds(40, 60, 100, 38);
        add(labelScoreUpdateLocal);
    }
    private void makeLabelScore() {
        labelScore = new JLabel("Score", SwingConstants.CENTER);
        labelScore.setForeground(Color.WHITE);
        labelScore.setFont(new Font("Arial", Font.BOLD, 15));
        labelScore.setBounds(40, 30, 100, 24);
        add(labelScore);
    }
}
