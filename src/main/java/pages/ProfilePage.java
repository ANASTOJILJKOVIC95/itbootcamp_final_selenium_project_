package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNameInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        return driver.findElement(By.id("name"));
    }
    public WebElement getPhoneInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        return driver.findElement(By.id("phone"));
    }
    public WebElement getCityInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        return driver.findElement(By.id("city"));
    }
    public WebElement getTwitterUrlInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("urlTwitter")));
        return driver.findElement(By.id("urlTwitter"));
    }
    public WebElement getGitHubUrlInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("urlGitHub")));
        return driver.findElement(By.id("urlGitHub"));
    }
    public WebElement getSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public WebElement getCountryInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
        return driver.findElement(By.id("country"));
    }
    public WebElement getEmailInput() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        return driver.findElement(By.id("email"));}
    public WebElement getMessage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//*[contains(text(),'Profile saved successfuly')]"))));
        return driver.findElement(By.xpath("//*[contains(text(),'Profile saved successfuly')]"));
    }

}
