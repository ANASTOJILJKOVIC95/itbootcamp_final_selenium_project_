package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    @Test (priority = 1)
    @Description("Test #1: Forbids visits to home url if not authenticated")
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.get(baseUrl+"home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    @Test (priority = 2)
    @Description("Test #2: Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.get(baseUrl+"profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    @Test (priority = 3)
    @Description("Test #3: Forbids visits to admin cities url if not authenticated")
    public void forbidsVisitsAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl+"admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    @Test (priority = 4)
    @Description("Test #4: Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
