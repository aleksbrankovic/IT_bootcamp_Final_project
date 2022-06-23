package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 1)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("login"), "[ERROR] The route /login does not appear in the page url");
    }

    @Test(priority = 2)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("login"), "[ERROR] The route /login does not appear in the page url");
    }

    @Test(priority = 3)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("login"), "[ERROR] The route /login does not appear in the page url");
    }

    @Test(priority = 4)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("login"), "[ERROR] The route /login does not appear in the page url");
    }

}
