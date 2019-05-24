package com.example;

import org.openqa.selenium.WebDriver;

public class Main {
    private static String driverPath = "C:\\Users\\Name\\Documents\\yure_2019\\testing\\gecko_driver\\";
    private static WebDriver driver;

    private static String source = "#source";
    private static String translation = ".tlid-translation.translation";

    public static void main(String[] words) {
        int cont = 1;
        for (String word : words){
            DriverController sc = new DriverController();
            sc.launchBrowser(word);
        }
    }
}
