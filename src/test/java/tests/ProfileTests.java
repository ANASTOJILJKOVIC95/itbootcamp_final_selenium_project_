package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class ProfileTests extends BasicTest {
        @Test(priority = 1)
        @Description("Test #1: Visits the profile page")
        public void visitsTheProfilePage() {
            navPage.getLoginButton().click();
            loginPage.getEmailInput().sendKeys("admin@admin.com");
            loginPage.getPasswordInput().sendKeys("12345");
            loginPage.getLoginButton().click();

            navPage.getMyProfileButton().click();
            Assert.assertEquals(driver.getCurrentUrl(),
                    baseUrl+"profile",
                    "Not on profile page");
            Assert.assertTrue(profilePage.getEmailInput().getAttribute("value").contains("admin@admin.com"),
                    "Admin is not logged in");
        }

        @Test(priority = 2)
        @Description("Test #2: Checks input types")
        void checksInputTypes() {
            navPage.getMyProfileButton().click();
            Assert.assertEquals(profilePage.getEmailInput().getAttribute("type"),
                    "email",
                    "This attribute does not have 'email' value");

            Assert.assertEquals(profilePage.getNameInput().getAttribute("type"),
                    "text",
                    "This attribute in name WebElement does not have 'text' value");

            Assert.assertEquals(profilePage.getCityInput().getAttribute("type"),
                    "text",
                    "This attribute in city WebElement does not have 'text' value");

            Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"),
                    "text",
                    "This attribute in Country WebElement does not have 'text' value");

            Assert.assertEquals(profilePage.getTwitterUrlInput().getAttribute("type"),
                    "url",
                    "This attribute in TwitterUrl WebElement does not have 'url' value");

            Assert.assertEquals(profilePage.getGitHubUrlInput().getAttribute("type"),
                    "url",
                    "This attribute in GitHub URL does not have 'url' value");
            Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"),
                    "tel",
                    "This attribute in Phone WebElement does not have 'tel' value");

        }

        @Test(priority = 3)
        @Description("Test #3: Edits profile")
        void editsProfile() {
            navPage.getMyProfileButton().click();

            profilePage.getNameInput().click();
            profilePage.getNameInput().sendKeys(Keys.CONTROL + "a");
            profilePage.getNameInput().sendKeys(Keys.BACK_SPACE);
            profilePage.getNameInput().sendKeys("Ana Stojiljkovic");

            profilePage.getPhoneInput().click();
            profilePage.getPhoneInput().sendKeys(Keys.CONTROL + "a");
            profilePage.getPhoneInput().sendKeys(Keys.BACK_SPACE);
            profilePage.getPhoneInput().sendKeys("+3816000003");

            profilePage.getCityInput().click();
            profilePage.getCityInput().sendKeys(Keys.CONTROL + "a");
            profilePage.getCityInput().sendKeys(Keys.BACK_SPACE);
            profilePage.getCityInput().sendKeys("Bucaramanga");

            profilePage.getCountryInput().click();
            profilePage.getCountryInput().sendKeys(Keys.CONTROL + "a");
            profilePage.getCountryInput().sendKeys(Keys.BACK_SPACE);
            profilePage.getCountryInput().sendKeys("Spain");

            profilePage.getTwitterUrlInput().click();
            profilePage.getTwitterUrlInput().sendKeys(Keys.CONTROL + "a");
            profilePage.getTwitterUrlInput().sendKeys(Keys.BACK_SPACE);
            profilePage.getTwitterUrlInput().sendKeys("https://twitter.com/profile/milan1232");

            profilePage.getGitHubUrlInput().click();
            profilePage.getGitHubUrlInput().sendKeys(Keys.CONTROL + "a");
            profilePage.getGitHubUrlInput().sendKeys(Keys.BACK_SPACE);
            profilePage.getGitHubUrlInput().sendKeys("https://github.com/anastojiljkovic");

            profilePage.getSubmitButton().sendKeys(Keys.ENTER);


            Assert.assertTrue(profilePage.getMessage().isDisplayed(),
                    "Save message is not displayed");
            Assert.assertTrue(profilePage.getMessage().getText().contains("Profile saved successfuly"),
                    "Profile is not saved");
            Assert.assertTrue(profilePage.getNameInput().getAttribute("value").contains("Ana Stojiljkovic"),
                    "Name input is not as expected");
            Assert.assertTrue(profilePage.getPhoneInput().getAttribute("value").contains("+3816000003"),
                    "Phone input is not as expected");
            Assert.assertTrue(profilePage.getCityInput().getAttribute("value").contains("Bucaramanga"),
                    "City input is not as expected");
            Assert.assertTrue(profilePage.getCountryInput().getAttribute("value").contains("Spain"),
                    "Country input is not as expected");
            Assert.assertTrue(profilePage.getTwitterUrlInput().getAttribute("value").
                    contains("https://twitter.com/profile/milan1232"),
                    "Twitter input is not as expected");
            Assert.assertTrue(profilePage.getGitHubUrlInput().getAttribute("value").
                            contains("https://github.com/anastojiljkovic"),
                    "GitHub input is not as expected");

            navPage.getLogoutButton().click();
        }
    }
