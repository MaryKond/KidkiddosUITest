import Pages.LogInPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class LogInNegativeTest extends UseCaseBase {

    protected static WebDriverWait wait;
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
    public void emptyFieldsTest() {


      loginPage.errorCheck();

          //wait = new WebDriverWait(webDiver, Duration.ofSeconds(3));

      // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));



   }


}
