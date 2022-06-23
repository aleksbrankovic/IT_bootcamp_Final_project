package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[1]"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }

    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-toolbar__items')]/a[3]"));
    }

    public WebElement getAdminButtonLink() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-toolbar__items')]/button[1]"));
    }

    public WebElement getCitiesLink() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-list')]/a[contains(@class,'btnAdminCities')]"));
    }

    public WebElement getUsersLink() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-list')]/a[contains(@class,''btnAdminUsers')]"));
    }

    public WebElement getSignUpLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
    }

    public WebElement getLoginButtonLink() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-toolbar__items')]/a[3]"));
    }

    public WebElement getLogoutButtonLink() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
    }

    public WebElement getLanguageButtonLink() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }

    public WebElement getEnLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class,'btnEN')]"));
    }

    public WebElement getEsLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));
    }

    public WebElement getFrLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));
    }

    public WebElement getCnLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));
    }

    public void chooseEnglishLanguage() {
        this.getLanguageButtonLink().click();
        this.getEnLanguageButton().click();
    }

    public void chooseSpanishLanguage() {
        this.getLanguageButtonLink().click();
        this.getEsLanguageButton().click();
    }

    public void chooseFrenchLanguage() {
        this.getLanguageButtonLink().click();
        this.getFrLanguageButton().click();
    }

    public void chooseChineseLanguage() {
        this.getLanguageButtonLink().click();
        this.getCnLanguageButton().click();
    }

    public void clickOnLoginNavButton() {
        this.getLoginButtonLink().click();
    }

    public void clickOnLogoutButton() {
        this.getLogoutButtonLink().click();
    }

    public void clickOnSignUpButton() {
        this.getSignUpLink().click();
    }

    public void clickOnAdminButton() {
        this.getAdminButtonLink().click();
    }

    public void chooseCities() {
        this.clickOnAdminButton();
        this.getCitiesLink().click();
    }

}