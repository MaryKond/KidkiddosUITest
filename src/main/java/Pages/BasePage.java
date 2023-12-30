package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

    }

    protected void clickElementByXpath(String xpath) {
        logger.info("Clicking element with xpath:" + xpath);
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    //not the best way to execute
    protected boolean elementExists(String xpath) {
        try {
            logger.info("Checking element with xpath:" + xpath);
            //findElementByXpath(xpath);
            webDriver.findElement(By.xpath(xpath));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    //wrapper
    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;

    }

    protected WebElement findElementByPartialLinkText(String text) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(text)));
        element = webDriver.findElement(By.partialLinkText(text));
        return element;
    }

    protected String getCurrentPageURL() {
        return webDriver.getCurrentUrl();

    }
    protected void clearField(String xpath){
        findElementByXpath(xpath).clear();
    }
    public String getValue(String xpath) {
        String qtyValue= webDriver.findElement(By.xpath(xpath)).getAttribute("value");
        return qtyValue;
    }

}
