package com.company.Controller.PanelController;

import com.company.ui.MyFrame;
import com.company.config.Const;

public class SettingController extends Controller{
    private Const aConst=Const.getInstance();

    public void setReso(String resolution) {
        String xy[] = resolution.split("x");
        aConst.setxReso(Integer.parseInt(xy[0]));
        aConst.setyReso(Integer.parseInt(xy[1]));
        MyFrame.getInstance().repaint();
    }
    public void setV(int i ) {
        aConst.setV(i*100);
    }
    public void setRotate(boolean i){
        aConst.setRotate(i);
    }


}
