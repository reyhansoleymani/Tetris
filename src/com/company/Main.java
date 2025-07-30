package com.company;

import com.company.ui.MyFrame;
import com.company.config.Config;

public class Main {
    public static void main(String[] args) {
        new Config();
        MyFrame.getInstance();
    }
}
