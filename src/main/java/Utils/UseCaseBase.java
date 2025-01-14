package Utils;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;



public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setUpMain(){
        page = new BasePage();
        webDriver= ShareDriver.getWebDriver(ShareDriver.Browser.FIREFOX);
        page.setWebDriver(webDriver);
    }
    @AfterAll
    public static void tearDown(){
        ShareDriver.closeDriver();
        webDriver=null;
    }
}
