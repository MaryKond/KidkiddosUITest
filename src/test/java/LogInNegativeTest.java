import Pages.LogInPage;
import Pages.MainPage;
import Utils.ShareDriver;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class LogInNegativeTest extends UseCaseBase {
static WebDriver driver;

    private static LogInPage loginPage;
    @BeforeAll
    public static void classSetUp (){
        loginPage=new LogInPage();

    }
    @BeforeEach
    public void beforeTest(){
        loginPage.navigateToLogInPage();
    }

   @Test
    public void emptyFieldsTest()throws InterruptedException {
      loginPage.clickSignIn();
       Thread.sleep(1000);
       WebElement error = driver.findElement(By.xpath("//*[contains(text(),'Incorrect email or password.')]"));
       assertNotNull(error);

   }


}
