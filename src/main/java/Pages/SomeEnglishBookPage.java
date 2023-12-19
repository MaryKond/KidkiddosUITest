package Pages;

import org.openqa.selenium.By;

public class SomeEnglishBookPage extends BasePage {
    private static final String BOOK_NAME = "//h1[contains(text(),'I Love to Go to Daycare ')]";
    private static final String FORMAT = "//select[@id='SingleOptionSelector-0']";
    private static final String HARDCOVER = "//*[text() = 'Hardcover']";


    public boolean isBookPageHeaderVisible() {
        Boolean isVisible = elementExists(BOOK_NAME);
        return isVisible;
    }

    public boolean locateFormat() {
        Boolean formatFieldFound = elementExists(FORMAT);
        return formatFieldFound;
    }

    public boolean chooseHardcover() {
        clickElementByXpath(FORMAT);
        clickElementByXpath(HARDCOVER);

        return true;
    }

    public String getFormatName() {
        String formatValue= webDriver.findElement(By.xpath(HARDCOVER)).getAttribute("value");
        return formatValue;
    }
}




