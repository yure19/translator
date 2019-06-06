package com.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static File tempFile;

    public static void main(String[] args) throws IOException{
        setProperties();

        String languageFrom = args[0];
        String languageTo = args[1];
        String wordToTranslate = args[2];

        DriverController controller = new DriverController();
        controller.launchBrowser(languageFrom, languageTo, wordToTranslate);

        if (tempFile != null){
            tempFile.delete();
        }
    }

    private static void setProperties() {
        //logging
        if (System.getProperty("java.util.logging.config.file") == null){
            InputStream input = Main.class.getResourceAsStream("/logging.properties");
            try {
                LogManager.getLogManager().readConfiguration(input);
            } catch (IOException io){
                io.printStackTrace();
            }
        }

        //browser logs
        if (System.getProperty("webdriver.firefox.logfile") == null){
            System.setProperty("webdriver.firefox.logfile", "/dev/null");
        }

        //geckodriver path
        if (System.getProperty("webdriver.gecko.driver") == null){
            tempFile = getTempGeckoFile();
            System.setProperty("webdriver.gecko.driver", tempFile.getPath());
        }
    }

    private static File getTempGeckoFile(){
        InputStream inputStream = Main.class.getResourceAsStream("/geckodriver.exe");

        File tempFile = null;
        try {
            tempFile = File.createTempFile("checkodriver", ".exe");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }

        try {
            Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
        return tempFile;
    }
}
