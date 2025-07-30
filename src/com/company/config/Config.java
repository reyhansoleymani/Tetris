package com.company.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Config {

    private Const aConst = Const.getInstance();
    private static final String CONFIG_PATH = "config.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public Config(){
        readFile();
        Runtime.getRuntime().addShutdownHook(new Thread(this::writeFile));
    }
    public void readFile(){
        File file = new File(CONFIG_PATH);
        if (!file.exists()) {
            aConst.loadDefaultShapes();
            writeFile();
            return;
        }
        try (Reader reader = new FileReader(file)) {
            Const loaded = gson.fromJson(reader, Const.class);
            aConst.copyFrom(loaded);
        } catch (IOException e) {
            System.out.println("Error reading config: " + e.getMessage());
        }
    }
    public void writeFile()
    {
        try (Writer writer = new FileWriter(CONFIG_PATH)) {
            gson.toJson(aConst, writer);
            System.out.println("Config saved to file.!:)");
        } catch (IOException e) {
            System.out.println("Error writing config: " + e.getMessage());
        }
    }

}
