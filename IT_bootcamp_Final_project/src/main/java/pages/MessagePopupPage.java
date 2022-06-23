package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopupPage {

    private WebDriver driver;

    public MessagePopupPage(WebDriver driver) {
        this.driver = driver;
    }

    public String headerMessage() {
        return driver.findElement(By.xpath("//div[contains(@class,'mb-3')]/h1")).getText();
    }

    public WebElement popupMessage() {
        return driver.findElement(By.xpath("//div[contains(@class,'container--fluid')]/div/div[3]/div/div/div/div/div[1]"));
    }

    public void waitToPopUpToBeVisible() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.visibilityOf(this.popupMessage()));
    }

    public String getTextFromPopup() {
        return this.popupMessage().getText();
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-snack__content')]/button"));
    }

    public void waitUserDoesNotExistDialogue() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'v-snack__content')]")));
    }

    public void waitToPopUpOfVisibilityDialogue() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class,'v-dialog--active')]")));
    }

    public String getVerifyAccountPopUpText() {
        return driver.findElement(By.xpath("//li[contains(text(),'User does not exists')]")).getText();
    }

    public WebElement getVerifyYourAccount() {
        return driver.findElement(By.xpath("//div[contains(@class,'dlgVerifyAccount')]"));
    }

    public WebElement getCloseButtonForVerify() {
        return driver.findElement(By.xpath("//button[contains(@class,'btnClose')]"));
    }

    public void waitWrongPasswordPopUp() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-snack__wrapper')]")));
    }

    public String getWrongPasswordPopUpText() {
        String popUpText = driver.findElement(By.xpath("//li[contains(text(),'Wrong password')]")).getText();
        return popUpText;
    }

    public void clickCloseButton() {
        getCloseButton().click();
    }

    public void closeVerifyDialogue() {
        this.getCloseButtonForVerify().click();
    }

}