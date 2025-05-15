package org.testpage;

import org.openqa.selenium.By;

import java.awt.event.MouseEvent;

public class HomePage extends BasePage {
    private By headerText = By.cssSelector("div[class='product_label']");
    private By logo = By.cssSelector("div[class='app_logo']");
    private By btnLogout = By.id("logout_sidebar_link");
    private By btnSidebar = By.cssSelector(".bm-burger-button button");

    public boolean isHomepageShow(){
        waitElementToBeVisible(headerText);
        waitElementToBeVisible(logo);
        if (findElement(headerText).isDisplayed() && findElement(logo).isDisplayed() && getCssValue(logo,"background-image").equals("url(\"https://www.saucedemo.com/v1/img/SwagLabs_logo.png\")")){
            return true;
        }else {
            return false;
        }
    }

    public LoginPage logout(){
        click(btnSidebar);
        waitElementToBeClick(btnLogout);
        return new LoginPage();
    }
}
