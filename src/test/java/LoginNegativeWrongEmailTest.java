import Pages.LogInPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNegativeWrongEmailTest extends UseCaseBase{


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
        public void wrongEmailTest() throws InterruptedException {

                Boolean exist2 = loginPage.checkFieldPasswordExist();
                assertTrue(exist2);
                Boolean exist3 = loginPage.checkFieldEmailExist();
                assertTrue(exist3);

                Boolean wrongEmail = loginPage.wrongEmailErrorCheck();
                assertTrue(wrongEmail);

//            wait = new WebDriverWait(webDiver, Duration.ofSeconds(3));
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));



        }


    }

