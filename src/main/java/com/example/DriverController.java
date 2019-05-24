package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverController {

    private String driverPath = "C:\\Users\\Name\\Documents\\yure_2019\\testing\\gecko_driver\\";
    private WebDriver driver;

    //selectors
    private static String source = "#source";
    private static String translation = ".tlid-translation.translation";

    public void launchBrowser(String wordToTranslate){
        String url = "https://translate.google.com/";
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        driver = new FirefoxDriver();

        driver.navigate().to(url);
        driver.findElement(By.cssSelector(source)).sendKeys(wordToTranslate);

        sleep(3000);

        System.out.println("Translated to English: " + driver.findElement(By.cssSelector(translation)).getText());
        closeDriver();
    }

    public void closeDriver() {
        if(driver!=null) {
            driver.close();
        }
    }

    private void sleep(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}