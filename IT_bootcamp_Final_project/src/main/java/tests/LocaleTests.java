package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 1)
    public void setLocaleToES() {
        navPage.chooseSpanishLanguage();
        Assert.assertTrue(messagePopupPage.headerMessage()
                .contains("Página de aterrizaje"), "[ERROR] The page doesn't contain message 'Page d'atterrissage'.");
    }

    @Test(priority = 2)
    public void setLocaleToEN() {
        navPage.chooseEnglishLanguage();
        Assert.assertTrue(messagePopupPage.headerMessage()
                .contains("Landing"), "[ERROR] The page doesn't contain message 'Landing'.");
    }

    @Test(priority = 3)
    public void setLocaleToCN() {
        navPage.chooseChineseLanguage();
        Assert.assertTrue(messagePopupPage.headerMessage()
                .contains("首页"), "[ERROR] The page doesn't contain message '首页'.");
    }

    @Test(priority = 4)
    public void setLocaleToFR() {
        navPage.chooseFrenchLanguage();
        Assert.assertTrue(messagePopupPage.headerMessage()
                .contains("Page d'atterrissage"), "[ERROR] The page doesn't contain message 'Page d'atterrissage'.");
    }

}
