package tests;

import Helper.Helper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected String baseUrl ="https://vue-demo.daniel-avellaneda.com/";
    protected String email;
    protected Random random;
    protected Helper helper;
    protected Actions actions;
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected ProfilePage profilePage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        this.helper = new Helper();
        this.softAssert = new SoftAssert();
        this.loginPage = new LoginPage(driver,wait);
        this.navPage = new NavPage(driver, wait);
        this.signupPage = new SignupPage(driver,wait);
        this.citiesPage = new CitiesPage(driver,wait);
        this.profilePage = new ProfilePage(driver,wait);
        this.messagePopUpPage = new MessagePopUpPage(driver,wait);
        this.random = new Random();
        int broj = random.nextInt(100);
        this.email = "ana.stojiljkovic"+broj+"@itbootcamp.rs";
    }
    @BeforeMethod
    public void beforeMethod (){
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File file = ((TakesScreenshot)driver).
                    getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss").format(new Date());
            Files.copy(file.toPath(), new
                    File("screenshots/" + result.getName() + " - " +
                    timestamp + ".png").toPath());}
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
