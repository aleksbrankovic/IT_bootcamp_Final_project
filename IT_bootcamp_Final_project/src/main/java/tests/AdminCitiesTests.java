package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
        navPage.clickOnLoginNavButton();
        loginPage.login(super.emailTest2, super.passwordTest2);
        Thread.sleep(2000);
        navPage.chooseCities();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("admin/cities"), "[ERROR] The route / admin/cities does not appear in the page url");
    }

    @Test(priority = 2)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.chooseCities();
        citiesPage.clickOnNewItem();
        citiesPage.waitNewOrEditItemDialogue();
        Assert.assertEquals(citiesPage.getNameInput()
                .getAttribute("type"), "text", "[ERROR] The name input field for the type attribute has no text value");
    }

    @Test(priority = 3)
    public void createNewCity() {
        navPage.chooseCities();
        citiesPage.addNewCity(super.city);
        messagePopupPage.waitToPopUpToBeVisible();
        Assert.assertEquals(messagePopupPage.getTextFromPopup().contains("Saved successfully"), true, "[ERROR] There is no 'Saved successfully' message");
    }

    @Test(priority = 4)
    public void editCity() {
        navPage.chooseCities();
        citiesPage.searchCities(super.city);
        citiesPage.editCity(1, super.city + " Edited");
        messagePopupPage.waitToPopUpToBeVisible();
        Assert.assertEquals(messagePopupPage.getTextFromPopup().contains("Saved successfully"), true, "[ERROR] There is no 'Saved successfully' message");
    }

    @Test(priority = 5)
    public void searchCity() {
        navPage.chooseCities();
        citiesPage.searchCities(super.city + " Edited");
        Assert.assertEquals(citiesPage.getCityName(1).contains(super.city + " Edited"), true, "[ERROR] There is no such city name in database");
    }

    @Test(priority = 6)
    public void deleteCity() {
        navPage.chooseCities();
        citiesPage.searchCities(super.city + " Edited");
        Assert.assertEquals(citiesPage.getCityName(1).contains(super.city + " Edited"), true, "[ERROR] There is no such city name in database");
        citiesPage.deleteCity(1);
        messagePopupPage.waitToPopUpToBeVisible();
        Assert.assertEquals(messagePopupPage.getTextFromPopup().contains("Deleted successfully"), true, "[ERROR] There is no 'Deleted successfully' message");
    }

}
