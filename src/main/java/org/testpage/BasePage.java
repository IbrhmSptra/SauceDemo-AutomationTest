package org.testpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait driverWait;

    public void setWebDriver(WebDriver webDriver, WebDriverWait driverWait) {
        BasePage.driver = webDriver;
        BasePage.driverWait = driverWait;
    }

    public void waitElementToBeClick(By locator){
        driverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitElementToBeVisible(By locator){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    protected void setInput(By locator, String input){
        waitElementToBeVisible(locator);
        if (input.isEmpty()){
            findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            return;
        }
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
