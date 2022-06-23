package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1)
    public void visitsTheLoginPage() {
        navPage.chooseEnglishLanguage();
        navPage.clickOnLoginNavButton();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("/login"), "[ERROR] The route / login does not appear in the page url");
    }

    @Test(priority = 2)
    public void checksInputTypes() {
        navPage.clickOnLoginNavButton();
        Assert.assertEquals(loginPage.getEmailInput()
                .getAttribute("type"), "email", "[ERROR] The email input field for the type attribute has no email value");
        Assert.assertEquals(loginPage.getPasswordInput()
                .getAttribute("type"), "password", "[ERROR] The password input field for the type attribute has no password value");
    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserDoesNotExist() {
        navPage.clickOnLoginNavButton();
        loginPage.login(super.emailTest1, super.passwordTest1);
        messagePopupPage.waitUserDoesNotExistDialogue();
        Assert.assertTrue(messagePopupPage.getVerifyAccountPopUpText().contains("User does not exists"), "[ERROR] There is no message");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[ERROR} The login route does not appear in the page url");
    }

    @Test(priority = 4)
    public void displaysErrorsWhenPasswordIsWrong() {
        navPage.clickOnLoginNavButton();
        loginPage.login(super.emailTest2, super.passwordTest1);
        messagePopupPage.waitWrongPasswordPopUp();
        Assert.assertTrue(messagePopupPage
                .getWrongPasswordPopUpText().contains("Wrong password"), "Text do not contain 'Wrong password'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Url do not contain '/login'");
    }

    @Test(priority = 5)
    public void login() throws InterruptedException {
        navPage.clickOnLoginNavButton();
        loginPage.login(super.emailTest2, super.passwordTest2);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "[ERROR] Current url does not contain '/home'");
    }

    @Test(priority = 6)
    public void logout() {
        Assert.assertTrue(navPage.getLogoutButtonLink().isDisplayed(), "[ERROR] '/logout' is not visible");
        navPage.clickOnLogoutButton();
    }

}