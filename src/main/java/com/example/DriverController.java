package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class DriverController {

    private WebDriver driver;

    //selectors
    private By source = By.cssSelector("#source");
    private By translation = By.cssSelector(".tlid-translation.translation");
    private By div_languageFrom = By.cssSelector(".sl-sugg > div:nth-child(2) > div:nth-child(1)");
    private By slSearchBox = By.cssSelector("#sl_list-search-box");
    private By esCheckmark = By.cssSelector(".language_list_item_icon.sl_list_es_s_checkmark");

    private By div_languageTo = By.cssSelector(".tl-sugg > div:nth-child(2) > div:nth-child(1)");
    private By tlSearchBox = By.cssSelector("#tl_list-search-box");
    private By enCheckmark = By.cssSelector(".language_list_item_icon.tl_list_en_s_checkmark");

    public void launchBrowser(String languageFrom, String languageTo, String wordToTranslate){
        String url = "https://translate.google.com/";

        driver = new FirefoxDriver();
        driver.navigate().to(url);

        //language from
        driver.findElement(div_languageFrom).click();
        driver.findElement(slSearchBox).click();
        driver.findElement(slSearchBox).sendKeys(languageFrom);
        driver.findElement(esCheckmark).click();

        //languaje to
        driver.findElement(div_languageTo).click();
        driver.findElement(tlSearchBox).click();
        driver.findElement(tlSearchBox).sendKeys(languageTo);
        driver.findElement(enCheckmark).click();

        driver.findElement(source).sendKeys(wordToTranslate);

        sleep(3000);

        System.out.println("\n\n Translated to English: " + driver.findElement(translation).getText() + "\n\n");

        closeDriver();
    }

    public void closeDriver() {
        if(driver != null) {
            driver.close();

            if(driver != null) {  //I kill the driver process
                String geckoName = Paths.get(System.getProperty("webdriver.gecko.driver")).getFileName().toString();

                try {
                    Runtime.getRuntime().exec("taskkill /F /IM " + geckoName + " /T");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sleep(5000); // wait two seconds, for later, to delete the temporary driver if was created
            }
        }
    }

    public void sleep(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}