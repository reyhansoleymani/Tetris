package com.company.Controller.PanelController;

import com.company.ui.MyFrame;
import com.company.ui.Panels.SettingPanel;
import com.company.ui.Panels.Tetris.Tetris;

public class MenuController extends Controller {
    public void startClick(){
        MyFrame.getInstance().changePanel(new Tetris());
    }
    public void settingClick(){
        MyFrame.getInstance().changePanel(new SettingPanel());
    }
}
