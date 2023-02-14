package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitsTheLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login",
                "Not on login page");
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email",
                "This attribute does not have 'email' value");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "This attribute dose not have 'password' value");
    }

    @Test(priority = 3)
    @Description("Test #3: Displays errors when user does not exist")
    public void displaysErrorWhenUserDoseNotExist() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();

        Assert.assertTrue(helper.elementExist(driver, By.xpath("//div[@class ='v-snack__content']")),
                "Error page is not displayed");

        Assert.assertEquals(messagePopUpPage.waitUntilPopUpIsVisible().getText(),
                "User does not exists",
                "Error message is not as expected");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on login page.");
    }

    @Test(priority = 4)
    @Description("Test #4: Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong() {

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();

        Assert.assertTrue(helper.elementExist(driver, By.
                        xpath("//div[contains(@class, 'v-snack__wrapper')]")),
                "Error page is not displayed");


        Assert.assertEquals(messagePopUpPage.waitUntilPopUpIsVisible().getText(),
                "Wrong password",
                "Error message is not as expected");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on login page.");
    }

    @Test(priority = 5)
    @Description("Test #5: Login")
    public void login() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on login page.");
    }

    @Test(priority = 6)
    @Description("Test #6: Logout")
    public void logout() {
        Assert.assertTrue(helper.elementExist(driver, By.className("v-btn__content")),
                "Logout button is not displayed.");
        navPage.getLogoutButton().click();
    }
}
