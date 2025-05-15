package org.testpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage{
    private By usernameInput = By.cssSelector("input[data-test='username']");
    private  By  passwordInput = By.cssSelector("input[data-test='password']");
    private By buttonLogin = By.cssSelector("input[type='submit']");
    private By logo = By.cssSelector("div[class='login_logo']");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public boolean isLoginPageShow(){
        if(findElement(logo).isDisplayed() && getCssValue(logo,"background-image").equals("url(\"https://www.saucedemo.com/v1/img/SwagLabs_logo.png\")") && findElement(buttonLogin).isDisplayed() && findElement(passwordInput).isDisplayed() && findElement(usernameInput).isDisplayed() && driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/index.html")){
            return  true;
        }else {
            return false;
        }
    }

    public HomePage loginToHomepage(String username, String password){
        setInput(usernameInput,username);
        setInput(passwordInput, password);
        click(buttonLogin);
        return new HomePage();
    }

    public String loginInvalid(String username, String password){
            setInput(usernameInput,username);
            setInput(passwordInput,password);
            click(buttonLogin);

        return  getText(errorMsg);
    }







}
