package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getSignMeUpButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'v-btn--contained')]"));
    }

    public void fillTheSignUpForm(String name, String email, String password) {
        this.getNameInput().sendKeys(name);
        this.getEmailInput().sendKeys(email);
        this.getPasswordInput().sendKeys(password);
        this.getConfirmPasswordInput().sendKeys(password);
        this.getSignMeUpButton().click();
    }

}