package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logwire.hooks.hooks;
import com.logwire.pages.adminPage;
import com.logwire.pages.dashboardPage;
import com.logwire.pages.loginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userStepDef {

    WebDriver driver = hooks.driver;
    loginPage lp= new loginPage(driver);
    dashboardPage dp=new dashboardPage(driver);
    adminPage ap=new adminPage(driver);
    private String un=null;

    @Given("je suis sur mon dashboard")
    public void je_suis_sur_mon_dashboard() {
       
    }

    @When("je clique sur {string}")
    public void je_clique_sur(String s) {
        dp.allerMenu(s);
    }

    @Then("le formulaire addUser s affiche")
    public void le_formulaire_addUser_s_affiche() {
        assertTrue(dp.getAddUserTitle().isDisplayed());
    }

    @When("je dois trouver mon utilisatuer dans la liste des utilisateurs")
    public void je_dois_trouver_mon_utilisatuer_dans_la_liste_des_utilisateurs() {
        WebElement table = ap.getUserTable();
        List<WebElement> rows=table.findElements(By.cssSelector("div[role='row']"));
        for(WebElement row : rows){
            List<WebElement> cells=row.findElements(By.cssSelector("div[role='cell']"));
            for(WebElement cell : cells){
                WebElement nom=cell.findElement(By.cssSelector(":nth(2)"));
                if(nom.getText()==un)
                {
                    assertTrue(true);
                    break;
                }
                    
            }

        }
        assertTrue(false);
    }

    @When("je clique sur save")
    public void je_clique_sur_save() {
        ap.saveUser();
    }

    @When("je sais mes infos depuis un fichier CSV")
    public void je_sais_mes_infos_depuis_un_fichier_CSV() {
        // Write code here that turns the phrase above into concrete actions
        List<String[]> donnees = lireFichierCSV("src/test/resources/data.csv");
        for(String[] line : donnees){
            un=line[3];
            ap.saisirUsername(line[3]);
            ap.saisirPassword(line[4]);
            ap.confirmPassword(line[5]);
            ap.selectRole();
            ap.selectEmployyName(line[1]);

        }
    }

    @Given("je suis connecter au dashboard")
    public void je_suis_connecter_au_dashboard() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        lp.doLogin("Admin", "admin123");
        // Map<String, String> localStorage = mapper.readValue(new File("localStorage.json"),
        // new TypeReference<Map<String, String>>() {});

        // for (Map.Entry<String, String> entry : localStorage.entrySet()) {
        //     js.executeScript("window.localStorage.setItem(arguments[0], arguments[1]);", entry.getKey(), entry.getValue());
        // }

    }

    private List<String[]> lireFichierCSV(String path)
    {
        List<String[]> lignes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] valeurs = ligne.split(","); // séparateur virgule
                lignes.add(valeurs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lignes;
    }
}
