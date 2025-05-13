package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testpage.LoginPage;

public class LoginPageTest extends BaseTest{
    final String ERROR_MSG_WRONG_CREDS = "Epic sadface: Username and password do not match any user in this service";
    final String ERROR_MSG_BLANK_USER = "Epic sadface: Username is required";
    final String ERROR_MSG_BLANK_PASS = "Epic sadface: Password is required";

    @Test
    public void entryPointLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageShow(),"Entry Point Website at Login Page");
    }
    @Test
    public void invalidCredentials(){
        String errorMsg = loginPage.loginInvalid("admin", "123");
        Assert.assertEquals(errorMsg,ERROR_MSG_WRONG_CREDS);
    }

}
