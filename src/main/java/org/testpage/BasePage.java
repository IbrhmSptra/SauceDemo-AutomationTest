package org.testpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public void setWebDriver(WebDriver webDriver) {
        BasePage.driver = webDriver;
    }

    protected WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    protected void setInput(By locator, String input){
        findElement(locator).clear();
        findElement(locator).sendKeys(input);
    }

    protected String getText(By locator){
        return findElement(locator).getText();
    }

    protected void click(By locator){
        findElement(locator).click();
    }

    protected String getCssValue(By locator, String prop){
        return findElement(locator).getCssValue(prop);
    }
}
