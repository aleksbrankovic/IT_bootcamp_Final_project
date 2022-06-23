package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//div[contains(@class,'flex')]/button"));
    }

    public void login(String email, String password) {
        this.getEmailInput().sendKeys(email);
        this.getPasswordInput().sendKeys(password);
        this.getLoginButton().click();
    }

}
