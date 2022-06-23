package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.xpath("//button[contains(@class,'btnNewItem')]"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void waitNewOrEditItemDialogue() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'dlgNewEditItem')]"))));
    }

    public void waitDeleteItemDialogue() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'v-dialog--active')]"))));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//button[contains(@class,'btnSave')]"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("//div[contains(@class,'rounded')]/div[2]/button[2]"));
    }

    public void waitForNumberOfTableRows(int numberOfRows) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr"), numberOfRows));
    }

    public WebElement getCell(int numberOfRow, int numberOfColumn) {
        return driver.findElement(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr[" + numberOfRow + "]/td[" + numberOfColumn + "]"));
    }

    public WebElement getRowEditButton(int numberOfRow) {
        return driver.findElement(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr[" + numberOfRow + "]/td[1]/div/button[1]"));
    }

    public WebElement getRowDeleteButton(int numberOfRow) {
        return driver.findElement(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr[" + numberOfRow + "]/td[1]/div/button[2]"));
    }

    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }

    public void clickOnNewItem() {
        this.getNewItemButton().click();
    }

    public void addNewCity(String city) {
        this.clickOnNewItem();
        this.waitNewOrEditItemDialogue();
        this.getNameInput().sendKeys(city);
        this.getSaveButton().click();
    }

    public void searchCities(String city) {
        this.getSearchInput().sendKeys(city);
        waitForNumberOfTableRows(1);
    }

    public void editCity(int numberOfRow, String city) {
        this.getRowEditButton(numberOfRow).click();
        this.getNameInput().sendKeys(Keys.CONTROL, "a");
        this.getNameInput().sendKeys(city);
        this.getSaveButton().click();
    }

    public String getCityName(int row) {
        return this.getCell(row, 2).getText();
    }

    public void deleteCity(int numberOfRow) {
        this.getRowDeleteButton(numberOfRow).click();
        this.waitDeleteItemDialogue();
        this.getDeleteButton().click();
    }

}