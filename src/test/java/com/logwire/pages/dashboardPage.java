package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {
    WebDriver driver;
    @FindBy(css = "img.oxd-userdropdown-img[alt=profile picture]")
    WebElement photoProfil;

    public dashboardPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public boolean isPictureDisplayed()
    {
        return photoProfil.isDisplayed();
    }
}
