package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton(){
        return driver.findElement(By.xpath("//button[contains(@class,'btnNewItem')]"));
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public void waitForDialogToBeDisplayed(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[contains(@class,'v-dialog--active')]")));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.xpath("//button[contains(@class,'btnSave')]"));
    }
    public WebElement getDeleteBox() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'v-btn')]")));}

    public List <WebElement> waitForNumberOfRowsToBe (int numberOfRows){
        return  wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//tbody/tr"), numberOfRows));
    }
    public WebElement getCell (int row, int cell){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+cell+"]"));
    }
    public WebElement getRowEditButton(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td//button"));
    }
    public WebElement getRowDeleteButton(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td//button[2]"));
    }
}
