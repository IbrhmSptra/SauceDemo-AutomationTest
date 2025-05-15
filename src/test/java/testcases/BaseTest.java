package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testpage.BasePage;
import org.testpage.LoginPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected ChromeOptions options;
    protected BasePage basePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        //disable chrome pop up
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");

        // Disable Chrome's password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
        basePage = new BasePage();
        basePage.setWebDriver(driver,driverWait);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }
}
