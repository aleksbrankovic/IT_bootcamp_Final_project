package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {

    @Test(priority = 1)
    public void visitsTheSignupPage() {
        navPage.clickOnSignUpButton();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("signup"), "[ERROR] The route / signup does not appear in the page url");
    }

    @Test(priority = 2)
    public void checksInputTypes() {
        navPage.clickOnSignUpButton();
        Assert.assertEquals(signUpPage.getEmailInput()
                .getAttribute("type"), "email", "[ERROR] The email input field for the type attribute has no email value");
        Assert.assertEquals(signUpPage.getPasswordInput()
                .getAttribute("type"), "password", "[ERROR] The password input field for the type attribute has no password value");
        Assert.assertEquals(signUpPage.getConfirmPasswordInput()
                .getAttribute("type"), "password", "[ERROR] The confirm password input field for the type attribute has no password value");
    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserAlreadyExist() {
        navPage.clickOnSignUpButton();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("signup"), "[ERROR] The route / signup does not appear in the page url");
        signUpPage.fillTheSignUpForm(super.username, super.emailTest2, super.passwordTest2);
        messagePopupPage.waitToPopUpToBeVisible();
        Assert.assertTrue(messagePopupPage
                .getTextFromPopup().contains("E-mail already exists"), "Text do not contain 'E-mail already exists'");
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("signup"), "[ERROR] The route / signup does not appear in the page url");
    }

    @Test(priority = 4)
    public void signUp() {
        navPage.clickOnSignUpButton();
        signUpPage.fillTheSignUpForm(super.username2, super.emailTest3, super.passwordTest2);
        messagePopupPage.waitToPopUpOfVisibilityDialogue();
        Assert.assertTrue(messagePopupPage
                .getVerifyYourAccount().getText().contains("IMPORTANT: Verify your account"), "Text do not contain 'IMPORTANT: Verify your account'");
        messagePopupPage.closeVerifyDialogue();
        navPage.clickOnLogoutButton();
    }

}
