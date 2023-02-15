package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the signup page")
    public void visitsTheSignupPage(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"signup",
                "Not on signup page");
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checksInputTypes(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"),
                "email",
                "This attribute does not have 'email' value");
        Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"),
                "password",
                "This attribute does not have 'password' value");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "This attribute does not have 'password' value");
    }
    @Test(priority = 3)
    @Description("Test #3: Displays errors when user already exists")
    public void displaysErrorWhenUserAlreadyExists(){
        navPage.getSignUpButton().click();
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getEmailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();

        Assert.assertTrue(helper.elementExist(driver, By.xpath("//div[@class ='v-snack__content']")),
                "Error page is not displayed");


        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "E-mail already exists",
                "Error message is not as expected");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"signup",
                "Not on login page.");
    }
    @Test(priority = 4)
    @Description("Test #4: Signup")
    public void singup() {
        navPage.getSignUpButton().click();
        signupPage.getNameInput().sendKeys("Ana Stojiljkovic");
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();


        Assert.assertEquals(messagePopUpPage.verifyAccountPopUp().getText(),
                "IMPORTANT: Verify your account",
                "Message is not as expected");
        messagePopUpPage.closeVerifyButton().click();
        navPage.getLogoutButton().click();

    }
}

