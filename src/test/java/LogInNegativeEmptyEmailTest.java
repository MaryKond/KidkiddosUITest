import Pages.LogInPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInNegativeEmptyEmailTest extends UseCaseBase {

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
        Boolean exist1 = loginPage.checkFieldEmailExist();
        assertTrue(exist1);
        Boolean emptyFieldsError = loginPage.errorCheck();
        assertTrue(emptyFieldsError);
    }
   }



