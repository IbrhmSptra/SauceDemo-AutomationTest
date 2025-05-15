package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testpage.HomePage;
import org.testpage.LoginPage;

public class LoginPageTest extends BaseTest{
    final String ERROR_MSG_WRONG_CREDS = "Epic sadface: Username and password do not match any user in this service";
    final String ERROR_MSG_BLANK_USER = "Epic sadface: Username is required";
    final String ERROR_MSG_BLANK_PASS = "Epic sadface: Password is required";
    final String ERROR_MSG_LOCKED_USER = "Epic sadface: Sorry, this user has been locked out.";
    final String LOCKED_USERNAME = "locked_out_user";
    final String[] VALID_USERNAME = {"standard_user","problem_user","performance_glitch_user"};
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
    public void userNameBlank() {

        String errorMsg = loginPage.loginInvalid("", VALID_PASSWORD);
        Assert.assertEquals(errorMsg,ERROR_MSG_BLANK_USER);
    }

    @Test
    public void passwordBlank(){
        String errorMsg = loginPage.loginInvalid(VALID_USERNAME[0], "");
        Assert.assertEquals(errorMsg, ERROR_MSG_BLANK_PASS);
    }

    @Test
    public void lockedUserLogin(){
        String errorMsg = loginPage.loginInvalid(LOCKED_USERNAME,VALID_PASSWORD);
        Assert.assertEquals(errorMsg,ERROR_MSG_LOCKED_USER);
    }

    @Test
    public void successLogin() {
        HomePage homePage = loginPage.loginToHomepage(VALID_USERNAME[0],VALID_PASSWORD);
        Assert.assertTrue(homePage.isHomepageShow());
        homePage.logout();
    }

    @Test
    public void tryAllValidUsername(){
        for(String s : VALID_USERNAME){
           HomePage homePage = loginPage.loginToHomepage(s,VALID_PASSWORD);
           Assert.assertTrue(homePage.isHomepageShow());
           homePage.logout();
        }
    }
}
