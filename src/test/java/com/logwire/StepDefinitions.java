package com.logwire;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.logwire.pages.dashboardPage;
import com.logwire.pages.loginPage;

public class StepDefinitions {

    WebDriver driver;
    loginPage lp;
    dashboardPage dp;
    @Before
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        lp= new loginPage(driver);
        dp= new dashboardPage(driver);
    }
    @After
    public void tearDown(){
        if (driver != null)
            driver.quit();
        driver = null;
    }
     

    @Given("je suis sur la page de {string}")
    public void je_suis_sur_la_page_de(String s) {
        driver.get(s);
    }

    @Then("j accede a mon compte")
    public void j_accede_a_mon_compte() {
        assertTrue(dp.isPictureDisplayed());
    }

    @Then("j obtient un message d erreur")
    public void j_obtient_un_message_d_erreur() {
        assertTrue(lp.gotErrorMessage());
    }

    @When("je saisi le username {string} et mot de passe {string}")
    public void je_saisi_le_username_et_mot_de_passe(String s, String s2) {
        lp.saisirUsername(s);
        lp.saisirPassword(s2);
    }

    @When("je clique sur le bouton de connexion")
    public void je_clique_sur_le_bouton_de_connexion() {
        lp.se_connecter();
    }

}
