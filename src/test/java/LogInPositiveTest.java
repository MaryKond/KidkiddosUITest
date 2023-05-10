import Pages.LogInPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LogInPositiveTest extends UseCaseBase {

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
    public void logInFieldsEmailExist(){
        Boolean exist1 = loginPage.checkFieldEmailExist();
        assertTrue(exist1);
        Boolean exist2 = loginPage.checkFieldPasswordExist();
        assertTrue(exist2);
    }

}
