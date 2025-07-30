package com.company.ui.Panels;

import com.company.Controller.PanelController.SettingController;
import com.company.config.Const;
import com.company.ui.MyFrame;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {
    private JCheckBox rotate;
    private JComboBox reso;
    private JSlider v;
    private Const aConst = Const.getInstance();
    private JButton back;
    private ت
    private SettingController controller = new SettingController();
    public SettingPanel(){
        setSize(aConst.getxReso(), aConst.getyReso());
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        makeBack();
        makeV();
        makeRotate();
        makeReso();
      ///  makeAddShape();
    }


    private void makeBack() {
        back = new JButton();
        back.setText("Back");
        back.setBounds(aConst.getxReso()-100, aConst.getyReso()-80, 70, 30);
        back.addActionListener(e -> {
            updateSetting();
            controller.backClick();
        });
        add(back);
    }

    private void updateSetting() {
        controller.setRotate(rotate.isSelected());
        controller.setV(v.getValue());
        controller.setReso( (String) reso.getSelectedItem());
        MyFrame.getInstance().setSize(aConst.getxReso(), aConst.getyReso());
        MyFrame.getInstance().repaint();
    }

    private void makeV() {
        JLabel speedLabel = new JLabel("Speed:");
        speedLabel.setFont(new Font("Arial", Font.BOLD, aConst.getyReso()/30));
        speedLabel.setBounds(aConst.getxReso()/4-75, aConst.getyReso()-200, 200, aConst.getyReso()/10);
        add(speedLabel);

        v = new JSlider(1, 10, 5);
        v.setMajorTickSpacing(1);
        v.setPaintTicks(true);
        v.setPaintLabels(true);
        v.setValue(11-(aConst.getV() / 100));
        v.setBounds(aConst.getxReso()/4, aConst.getyReso()-200, aConst.getxReso()/2, aConst.getyReso()/10);
        controller.setV(v.getValue());
        add(v);
    }
    private void makeRotate() {
        rotate = new JCheckBox("Enable Rotation");
        rotate.setBounds(aConst.getxReso()/4, aConst.getyReso()/3 -100, aConst.getxReso()/2, aConst.getyReso()/10);
        rotate.setSelected(aConst.isRotate());
        controller.setRotate(rotate.isSelected());
        add(rotate);
    }
    private void makeReso() {
        JLabel resolutionLabel = new JLabel("Resolution:");
        resolutionLabel.setFont(new Font("Arial", Font.BOLD, aConst.getyReso()/30));
        resolutionLabel.setBounds(aConst.getxReso()/4-120, 2*(aConst.getyReso()/3) -150, 200, aConst.getyReso()/10);
        add(resolutionLabel);

        String[] resolutions = {"430x450", "800x600", "500x500"};
        reso = new JComboBox<>(resolutions);
        String currentReso = aConst.getxReso() + "x" + aConst.getyReso();
        reso.setSelectedItem(currentReso);
        reso.setBounds(aConst.getxReso()/4, 2*(aConst.getyReso()/3)-150, aConst.getxReso()/2, aConst.getyReso()/10);
        controller.setReso((String) reso.getSelectedItem());

        add(reso);
    }
}
