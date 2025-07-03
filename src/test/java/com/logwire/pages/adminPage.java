package com.logwire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.logwire.tools.driverManager;

public class adminPage {

    @FindBy(css="input.oxd-input.oxd-input--active")
    WebElement username;
    @FindBy(css="input[placeholder='Type for hints...']")
    WebElement employeeName;
    @FindBy(css="div.oxd-input-group:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    WebElement password;
    @FindBy(css="div.oxd-form-row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement confirm;
    @FindBy(css="div.oxd-form-row:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    WebElement role;
    @FindBy(css="div.oxd-grid-item:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    WebElement status;
    @FindBy(css="button[data-v-10d463b7]")
    WebElement addButton;
    @FindBy(css="span[data-v-7b563373]")
    WebElement totalRecords;
    @FindBy(css="data-v-10d463b7")
    WebElement saveButton;
    @FindBy(css="data-v-f2168256")
    WebElement userTable;

    public adminPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void saisirUsername(String s){
        username.sendKeys(s);
    }

    public void saisirPassword(String p){
        password.sendKeys(p);
    }
    public void confirmPassword(String p){
        confirm.sendKeys(p);
    }

    public void selectRole()
    {
        role.click();
        driverManager.getCurrentDriver()
        .findElement(By.xpath("//div[@role='option']/span[text()='ESS']"))
        .click();
    }
    public void selectEmployyName(String s)
    {
        employeeName.sendKeys(s);
    }

    public void saveUser()
    {
        saveButton.click();
    }

    public WebElement getUserTable(){
        return userTable;
    }
}
