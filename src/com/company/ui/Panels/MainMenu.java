package com.company.ui.Panels;

import com.company.Controller.PanelController.MenuController;
import com.company.config.Const;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private  JLabel mainPageLabel;
    private JButton startGamePageButton;
    private JButton settingButton;
    private MenuController controller=new MenuController();
    private Const aConst=Const.getInstance();

    public MainMenu() {
        setSize(aConst.getxReso(), aConst.getyReso());
        setLayout(null);
        makeStartGame();
        makeSettingButton();
        makeLabel();
        setBackground(Color.DARK_GRAY);
        setVisible(true);
    }
    private void makeLabel() {
        mainPageLabel = new JLabel("Welcome!", SwingConstants.CENTER);
        mainPageLabel.setForeground(Color.BLACK);
        mainPageLabel.setFont(new Font("Arial", Font.BOLD, aConst.getyReso()/10));
        mainPageLabel.setBounds(aConst.getxReso()/4  , 60, aConst.getyReso()/2, 100);
        add(mainPageLabel);
    }
    private void makeSettingButton() {
        settingButton = new JButton();
        settingButton.setText("Setting");
        settingButton.setBackground(Color.GRAY);
        settingButton.setFont(new Font("Arial", Font.BOLD, aConst.getyReso()/20));
        settingButton.setBounds(aConst.getxReso()/4, aConst.getyReso()/2, aConst.getxReso()/4, aConst.getyReso()/8);
        settingButton.addActionListener(e -> {
            controller.settingClick();
        });
        add(settingButton);
    }
    private void makeStartGame() {
        startGamePageButton = new JButton();
        startGamePageButton.setText("Start");
        startGamePageButton.setBackground(Color.GRAY);
        startGamePageButton.setFont(new Font("Arial", Font.BOLD, aConst.getyReso()/20));
        startGamePageButton.setBounds(aConst.getxReso()/2, aConst.getyReso()/2, aConst.getxReso()/4, aConst.getyReso()/8);
        startGamePageButton.addActionListener(e -> {
           controller.startClick();
        });
        add(startGamePageButton);
    }



}
