import Pages.SomeEnglishBookPage;
import Pages.EnglishOnlyPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SomeEnglishBookPageTest extends UseCaseBase {
    private static EnglishOnlyPage englishOnlyPage;
    private static MainPage mainPage;
    private static SomeEnglishBookPage englishBookPage;

    @BeforeAll
    public static void classSetUp (){
        englishOnlyPage=new EnglishOnlyPage();
        mainPage=new MainPage();
        englishBookPage=new SomeEnglishBookPage();

    }
    @BeforeEach
    public void beforeTest(){
        mainPage.navigateToToMainPage();
        mainPage.navigateEnglishOnlyPage();
        englishOnlyPage.clickOnBook();
    }
    @Test
    public void chooseHardcover(){

    }
}
