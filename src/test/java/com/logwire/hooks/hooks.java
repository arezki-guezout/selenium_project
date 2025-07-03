package com.logwire.hooks;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.logwire.pages.dashboardPage;
import com.logwire.pages.loginPage;
import com.logwire.tools.driverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

    public static WebDriver driver;
    public static Map<String, String> localStorage = new HashMap<>();
    @Before
    public void setup(){
        //driver= new ChromeDriver();
        driverManager.initializeDriver();
        driver = driverManager.getCurrentDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        
    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            try {

                WebDriver driver = driverManager.getCurrentDriver();
                if (driver != null) {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Capture d'écran");
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la capture d'écran: " + e.getMessage());
            }
        }

        driverManager.destroyDriver();
    }
}
