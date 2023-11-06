package Pages;

import Consts.Consts;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {
    private static final String LOG_IN_HEADER = "//h1[text()='Login']";
    private static final String LOGIN_LOGO = "//*[@class='icon icon-login']";
    private static final String EMAIL_XPATH = "//input[@id='CustomerEmail']";
    public static final String PASSWORD_XPATH = "//input[@id='CustomerPassword']";
    public static final String SIGN_IN_XPATH = "//input[@type='submit']";
    public static final String ERROR_MESSAGE = "//*[contains(text(),'Please enter an email address.')]";
    //public static final String [] fields = {EMAIL_XPATH,PASSWORD_XPATH};

    private static BasePage basePage;
    public void navigateToLogInPage() {
        webDriver.get(Consts.LOGIN_URL);
    }

    public boolean isTitleVisible() {
        return elementExists(LOG_IN_HEADER);
    }

    public boolean checkFieldEmailExist() {
        Boolean existsEmail = elementExists(EMAIL_XPATH);
        return existsEmail;
    }

    public boolean checkFieldPasswordExist() {
        Boolean existsPassword = elementExists(PASSWORD_XPATH);
        return existsPassword;
    }

    //public void clickSignIn() {

        //clickElementByXpath(EMAIL_XPATH);

        //basePage.sendTextToElementByXpath(EMAIL_XPATH," ");
        //clickElementByXpath(PASSWORD_XPATH);


    public boolean errorCheck() {
        basePage= new BasePage();
   basePage.sendTextToElementByXpath(EMAIL_XPATH, " ");
        clickElementByXpath(SIGN_IN_XPATH);
        Boolean error=elementExists(ERROR_MESSAGE);
        return error;
    }
        //basePage.findElementByXpath(ERROR_MESSAGE);}


}
