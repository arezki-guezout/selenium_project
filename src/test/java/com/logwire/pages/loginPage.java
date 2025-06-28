package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver driver;
    @FindBy(css = "input[name=username]")
    WebElement username;

    @FindBy(css= "input[name=password]")
    WebElement password;  

    @FindBy(css= "button[type=submit]")
    WebElement login;

    @FindBy(css= "div.oxd-alert.oxd-alert--error")
    WebElement errorMessage;

    

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void saisirUsername(String s)
    {   
        this.username.sendKeys(s);
    }
    public void saisirPassword(String s)
    {   
        this.password.sendKeys(s);
    }
    public void se_connecter()
    {
        login.click();
    }
    public boolean gotErrorMessage()
    {
        return errorMessage.isDisplayed();
    }
}
