package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testpage.BasePage;
import org.testpage.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
        basePage = new BasePage();
        basePage.setWebDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
