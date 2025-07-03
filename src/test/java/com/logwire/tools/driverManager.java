package com.logwire.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverManager {
    public static WebDriver driver;

    public static void initializeDriver()
    { driver = new ChromeDriver(); }

    public static void destroyDriver()
    { 
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }

    public static WebDriver getCurrentDriver(){
        return driver;
    }
}
