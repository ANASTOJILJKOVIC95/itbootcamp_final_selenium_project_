package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHomeButton(){
        return driver.findElement(By.cssSelector("a[href='/']"));
    }
    public WebElement getAboutButton(){
        return driver.findElement(By.cssSelector("a[href='/about']"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));}
    public WebElement getSignUpButton(){
        return driver.findElement(By.cssSelector("a[href='/signup']"));
    }
    public WebElement getMyProfileButton(){
        return driver.findElement(By.cssSelector("a[href='/profile']"));
    }
    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }
    public WebElement getUsersButton(){ return driver.findElement(By.cssSelector("a[href='/admin/users']"));
    }
    public WebElement getCitiesButton(){
        return driver.findElement(By.cssSelector("a[href='/admin/cities']"));
    }
    public WebElement getProfileButton(){
        return driver.findElement(By.cssSelector("a[href='/profile']"));
    }
    public WebElement getLanguageButton() {
        return driver.findElement(
                By.xpath("//button[contains(@class, 'btnLocale')]"));}
    public WebElement getEnglishLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnEN')]"));}
    public WebElement getSpanishLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));}
    public WebElement getFrenchLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));}
    public WebElement getChineseLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));}
    public WebElement getUkrainianLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnUA')]"));
    }
}
