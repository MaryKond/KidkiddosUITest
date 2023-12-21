package Pages;

import org.openqa.selenium.By;

public class SomeEnglishBookPage extends BasePage {
    private static final String BOOK_NAME = "//h1[contains(text(),'I Love to Go to Daycare ')]";
    private static final String FORMAT = "//select[@id='SingleOptionSelector-0']";
    private static final String HARDCOVER = "//*[text() = 'Hardcover']";
    private static final String QTY = "//input[@id='Quantity']";
    private static final String ADD_TO_CART = "//span[@id='AddToCartText-product-template']";
    private static final String YOUR_CART = "//*[text() = 'Your cart']";


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
    public boolean chooseNewQty(){
      elementExists(QTY);
      clearField(QTY);
        sendTextToElementByXpath(QTY,"5");
        return true;
    }
    public String getQty() {
        String qtyValue= webDriver.findElement(By.xpath(QTY)).getAttribute("value");
        return qtyValue;
    }


    public CartPage clickAddToCart(){
        clickElementByXpath(ADD_TO_CART);
        return new CartPage();
    }
    public boolean isPageTitleVisible() {
        return elementExists(YOUR_CART);
    }
}




