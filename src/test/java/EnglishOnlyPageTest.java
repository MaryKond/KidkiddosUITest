import Pages.EnglishOnlyPage;
import Pages.LogInPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnglishOnlyPageTest extends UseCaseBase {
    private static EnglishOnlyPage englishOnlyPage;
    private static MainPage mainPage;


    @BeforeAll
    public static void classSetUp (){
        englishOnlyPage=new EnglishOnlyPage();
        mainPage=new MainPage();
    }
    @BeforeEach
    public void beforeTest(){
        mainPage.navigateToToMainPage();
        mainPage.navigateEnglishOnlyPage();
    }
    @Test
    public void choseBook(){
        englishOnlyPage.closePopUpWindow();


    }
}
