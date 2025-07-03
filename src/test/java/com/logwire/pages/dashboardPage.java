package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {
    //WebDriver driver;
    @FindBy(css = "img.oxd-userdropdown-img[alt='profile picture']")
    WebElement photoProfil;
    @FindBy(css="a[href='web/index.php/admin/viewAdminModule']")
    WebElement adminMenu;
    @FindBy(css="a[href='/web/index.php/recruitment/viewRecruitmentModule']")
    WebElement recruitmentMenu;
    @FindBy(css="h6[data-v-7b563373]")
    WebElement addUserTitle;
    @FindBy(css="button[type='submit']")
    WebElement saveButton;
    

    public dashboardPage(WebDriver driver)
    { PageFactory.initElements(driver, this); }

    public boolean isPictureDisplayed()
    { return photoProfil.isDisplayed(); }

    public void allerMenu(String menu){
        switch(menu)
        {
            case "Admin":
                allerMenuAdmin();
                break;
            case "Recruitment":
                allerMenuRecruitment();
                break;
        }
    }

    public WebElement getAddUserTitle()
    { return addUserTitle; }

    public void saveUser()
    { saveButton.click(); }

    private void allerMenuAdmin()
    { adminMenu.click(); }

    private void allerMenuRecruitment()
    { recruitmentMenu.click(); }
}
