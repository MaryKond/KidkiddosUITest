package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    private static final String LOG_IN_HEADER = "//h1[text()='Login']";
    private static final String LOGIN_LOGO = "//*[@class='icon icon-login']";
    private static final String EMAIL_XPATH = "//input[@id='CustomerEmail']";
    public static final String PASSWORD_XPATH = "//input[@id='CustomerPassword']";
    public static final String SIGN_IN_XPATH = "//input[@type='submit']";
    public static final String ERROR_MESSAGE = "//*[contains(text(),'Please enter an email address.')]";
    //public static final String WRONG_EMAIL_ERROR_MESSAGE = "//*[contains(text(),'Incorrect email or password.']";
    public static final String WRONG_EMAIL_ERROR_MESSAGE = "//li[contains(text(),'Incorrect email or password.')]" ;
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
   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGN_IN_XPATH)));
        clickElementByXpath(SIGN_IN_XPATH);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR_MESSAGE)));
        Boolean error=elementExists(ERROR_MESSAGE);
        return error;
    }

        public boolean wrongEmailErrorCheck() throws InterruptedException {
            basePage= new BasePage();
            basePage.sendTextToElementByXpath(EMAIL_XPATH, "blah.blah@gmail.com");
            Thread.sleep(5000);
            basePage.sendTextToElementByXpath(PASSWORD_XPATH, "8hfhfgdjdjdgids!");
            Thread.sleep(5000);
            clickElementByXpath(SIGN_IN_XPATH);
            Thread.sleep(5000);
            Boolean error2=elementExists(WRONG_EMAIL_ERROR_MESSAGE);
            return error2;
        }


}
