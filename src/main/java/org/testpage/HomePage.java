package org.testpage;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By headerText = By.cssSelector("div[class='product_label']");
    private By logo = By.cssSelector("div[class='app_logo']");

    public boolean isHomepageShow(){
        if (findElement(headerText).isDisplayed() && findElement(logo).isDisplayed() && getCssValue(logo,"background").equals("url(../img/SwagLabs_logo.png) no-repeat center center")){
            return true;
        }else {
            return false;
        }
    }
}
