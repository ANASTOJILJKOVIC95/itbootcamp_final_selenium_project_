package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement waitUntilPopUpIsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div/ul/li")));
    }

    public WebElement getCloseButton() {
        return wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@class='v-btn__content']")));
    }

    public WebElement verifyAccountPopUp() {
        return driver.findElement
                (By.xpath("//div[contains(@class,'dlgVerifyAccount')]"));
    }

    public WebElement verifyHeader() {
        return driver.findElement
                (By.xpath("//*[contains(@class,'display-2')]"));
    }

    public WebElement closeVerifyButton() {
        return driver.findElement(
                By.xpath("//button[contains(@class, 'btnClose')]"));
    }

    public WebElement getVerifyMessage() {
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }

    public WebElement getSaveMessage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Saved successfully')"
                + "]"))));
        return driver.findElement(By.xpath("//*[contains(text(),'Saved successfully')]"));
    }


    public WebElement getNewCityField() {
        return driver.findElement(
                By.xpath("//div[@class='v-text-field__slot']/input[@id='name']"));
    }
    public WebElement getDeleteButton(){
    return driver.findElement(By.xpath("//div[@class='v-card__actions']/button[2]"));}
    public WebElement getDeleteMessage() {
        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.xpath("//*[contains(text(),'Deleted successfully')]"))));
        return driver.findElement(By.xpath("//*[contains(text(),'Deleted successfully')]"));
    }
    public void clearInputField() {
        WebElement element = driver.findElement
                (By.xpath("//div[@class='v-text-field__slot']/input[@id='name']"));
        for (int i = 0; i < 50; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
}
