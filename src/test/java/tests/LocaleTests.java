package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
    @Test(priority = 1)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),
                "Página de aterrizaje",
                "Language is not changed to spanish");
    }
    @Test(priority = 2)
    @Description("Test #2: Set locale to EN")
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),
                "Landing",
                "Language is not changed to spanish");
    }
    @Test(priority = 3)
    @Description("Test #3: Set locale to  CN")
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),
                "首页",
                "Language is not changed to spanish");
    }
    @Test(priority = 4)
    @Description("Test #4: Set locale to  FR")
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),
                "Page d'atterrissage",
                "Language is not changed to spanish");
    }


}
