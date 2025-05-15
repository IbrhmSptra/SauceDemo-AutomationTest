package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testpage.LoginPage;

public class LoginPageTest extends BaseTest{
    final String ERROR_MSG_WRONG_CREDS = "Epic sadface: Username and password do not match any user in this service";
    final String ERROR_MSG_BLANK_USER = "Epic sadface: Username is required";
    final String ERROR_MSG_BLANK_PASS = "Epic sadface: Password is required";
    final String VALID_USERNAME = "standard_user";
    final String VALID_PASSWORD = "secret_sauce";

    @Test
    public void entryPointLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageShow(),"Entry Point Website at Login Page");
    }
    @Test
    public void invalidCredentials(){
        String errorMsg = loginPage.loginInvalid("admin", "123");
        Assert.assertEquals(errorMsg,ERROR_MSG_WRONG_CREDS);
    }

    @Test
    public void allFieldBlank(){
        String errorMsg = loginPage.loginInvalid("","");
        Assert.assertEquals(errorMsg,ERROR_MSG_BLANK_USER);
    }

    @Test
    public void userNameBlank(){
        String errorMsg = loginPage.loginInvalid("", VALID_PASSWORD);
        Assert.assertEquals(errorMsg,ERROR_MSG_BLANK_USER);
    }

    @Test
    public void passwordBlank(){
        String errorMsg = loginPage.loginInvalid(VALID_USERNAME, "");
        Assert.assertEquals(errorMsg, ERROR_MSG_BLANK_PASS);
    }
}
