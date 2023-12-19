import Pages.SomeEnglishBookPage;
import Pages.EnglishOnlyPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnglishOnlyPageTest extends UseCaseBase {
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
    }
    @Test
    public void EnglishOnlyPageExist(){

        Boolean exist = englishOnlyPage.isTitleVisible();
        englishOnlyPage.closePopUpWindow();
        assertTrue(exist);

    }


}
