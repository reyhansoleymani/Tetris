package com.company.Controller.PanelController;

import com.company.ui.MyFrame;
import com.company.ui.Panels.MainMenu;

public abstract class Controller {
    public void backClick() {
        MyFrame.getInstance().changePanel(new MainMenu());
    }
}
