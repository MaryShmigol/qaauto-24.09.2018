import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RequestPasswordTest {
    private WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://linkedin.com");
        loginPage = new LoginPage(webDriver);
    }
    @AfterMethod
    public void afterMethod() {

        webDriver.quit();
    }
    @Test
    public void RequestPassword(){
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        RequestPage requestPage = loginPage.clickOnForgotPassword();
        Assert.assertTrue(requestPage.isRequestPageLoaded(),"Request Page is not loaded");
    }
}


