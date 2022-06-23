package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignUpPage signUpPage;
    protected CitiesPage citiesPage;
    protected MessagePopupPage messagePopupPage;
    protected String emailTest1 = "non-existing-user@gmal.com";
    protected String emailTest2 = "admin@admin.com";
    protected String emailTest3 = "aleksandra.brankovic@itbootcamp.com";
    protected String passwordTest1 = "password123";
    protected String passwordTest2 = "12345";
    protected String username = "Another User";
    protected String username2 = "Aleksandra Brankovic";
    protected String city = username2 + "'s city";


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        signUpPage = new SignUpPage(driver);
        citiesPage = new CitiesPage(driver);
        messagePopupPage = new MessagePopupPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}