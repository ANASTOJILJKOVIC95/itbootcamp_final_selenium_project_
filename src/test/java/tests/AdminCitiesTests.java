package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitTheAdminCitiesPageAndListCities(){
        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"admin/cities",
                "Not on admin cities page");
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checksInputTypesForCreateEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogToBeDisplayed();
        Assert.assertEquals(messagePopUpPage.getVerifyMessage().getAttribute("type"),
                "text",
                "This attribute does not have 'text' value");
    }
    @Test(priority = 3)
    @Description("Test #3: Create new city")
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogToBeDisplayed();
        messagePopUpPage.getNewCityField().sendKeys("St. Ana's city");
        messagePopUpPage.getSaveButton().click();
        Assert.assertTrue(messagePopUpPage.getSaveMessage().getText().contains("Saved successfully"),
                "City is not created");

    }
    @Test(priority = 4)
    @Description("Test #4: Edit city")
    public void editCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys("St. Ana's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getRowEditButton(1).click();
        messagePopUpPage.clearInputField();
        messagePopUpPage.getNewCityField().sendKeys("Ana's city");
        citiesPage.getSaveButton().click();
        Assert.assertTrue(messagePopUpPage.getSaveMessage().getText().contains("Saved successfully"),
                "City is not edited");

    }
    @Test(priority = 5)
    @Description("Search city")
    public void searchCity() {


        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys("Ana's city");
        citiesPage.waitForNumberOfRowsToBe(1);

        Assert.assertEquals(citiesPage.getCell(1,2).getText(),
                "Ana's city",
                "Searched city is not found");
    }
    @Test(priority = 60)
    @Description(" Delete city")
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys("Ana's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCell(1,2).getText(),
                "Ana's city",
                "Error message is wrong");
        citiesPage.getRowDeleteButton(1).click();
        messagePopUpPage.getDeleteButton().click();
        Assert.assertTrue(messagePopUpPage.getDeleteMessage().getText().contains("Deleted successfully"),
                "City is not deleted");

    }
}
