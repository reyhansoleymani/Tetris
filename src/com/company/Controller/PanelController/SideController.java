package com.company.Controller.PanelController;

import com.company.logic.GameEngine;
import javax.swing.*;

public class SideController extends Controller {


    private GameEngine engine;
    private boolean paused = false;
    private boolean started = false;

    public SideController(GameEngine engine)
    {
        this.engine=engine;
    }
    public void pauseClick(JButton pauseButton) {
        if (started && !engine.getModel().gameOver()) {
            if (!paused) {
                pauseButton.setText("Resume");
                engine.stop();
                paused = true;
            } else {
                pauseButton.setText("Pause");
                engine.start();
                paused = false;
            }
        }
    }
    public void startClick(JButton startButton) {
        if (!started) {
            startButton.setText("Reset");
            engine.start();
            started = true;
        } else {
            engine.reset();
            startButton.setText("Start");
            started = false;
        }
    }
}
