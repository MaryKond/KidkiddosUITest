package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String CONTACT_US = "//a[text()='Contact us']";
    private static final String LOGIN_LOGO = "//*[@class='icon icon-login']";
    private static final String BOOKS_BY_LANGUAGE_MENU = "//a[@aria-controls ='SiteNavLabel-books-by-language']";
    private static final String ENGLISH_ONLY = "//a[text()='English Only']";

    public void navigateToToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }
    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
    public ContactUsPage openContactUsTab(){
        clickElementByXpath(CONTACT_US);
        return new ContactUsPage();
    }
    public LogInPage navigateToLogInPage(){
        clickElementByXpath(LOGIN_LOGO);
        return new LogInPage();
    }
    public EnglishOnlyPage navigateEnglishOnlyPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BOOKS_BY_LANGUAGE_MENU)));
        clickElementByXpath(BOOKS_BY_LANGUAGE_MENU);
        clickElementByXpath(ENGLISH_ONLY);

        return new EnglishOnlyPage();
    }


}
