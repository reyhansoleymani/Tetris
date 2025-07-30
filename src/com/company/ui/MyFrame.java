package com.company.ui;

import com.company.config.Const;
import com.company.ui.Panels.MainMenu;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static MyFrame frame;
    private JPanel myPanel;
    private Const aConst= Const.getInstance();

    public static MyFrame getInstance()
    {
        if(frame==null)frame=new MyFrame();
        return frame;
    }

    private MyFrame()
    {
        setSize(aConst.getxReso(), aConst.getyReso());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
        myPanel = new MainMenu();
        add(myPanel);
    }
    public void changePanel(JPanel panel)
    {
        myPanel.setVisible(false);
        remove(myPanel);
        myPanel = panel;
        myPanel.setVisible(true);
        add(myPanel);
    }

}
