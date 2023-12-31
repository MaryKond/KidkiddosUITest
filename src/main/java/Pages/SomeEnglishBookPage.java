package Pages;

import org.openqa.selenium.By;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SomeEnglishBookPage extends BasePage {
    private static final String BOOK_NAME = "//h1[contains(text(),'I Love to Go to Daycare ')]";
    private static final String FORMAT = "//select[@id='SingleOptionSelector-0']";
    private static final String HARDCOVER = "//*[text() = 'Hardcover']";
    private static final String QTY = "//input[@id='Quantity']";
    private static final String CART_QTY2 = "//input[@class='cart__qty-input']";
    private static final String ADD_TO_CART = "//span[@id='AddToCartText-product-template']";
    private static final String YOUR_CART = "//*[text() = 'Your cart']";
    private static final String UPDT_BUTTON = "//input[@class = 'btn btn--secondary cart__update cart__update--large small--hide']";
    private static final String PRICE = "//td[@class = 'cart__price-wrapper cart-flex-item']//descendant::span[@class = 'currency-converter-amount cbb-price-currency-CAD']";   // $x("td[@class = 'cart__price-wrapper cart-flex-item']//descendant::span[@class = 'cbb-price-digits']") ""
    private static final String TOTAL_PRICE = "//td[@class = 'text-right small--hide']//descendant::span[@class = 'cbb-price-digits']"; //td[@class = 'text-right small--hide']"


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



    public CartPage clickAddToCart(){
        clickElementByXpath(ADD_TO_CART);
        return new CartPage();
    }
    public boolean isPageTitleVisible() {
        return elementExists(YOUR_CART);
    }
    public boolean NewQtyCart(){
        elementExists(CART_QTY2);
        clearField(CART_QTY2);
        sendTextToElementByXpath(CART_QTY2,"6");
        return true;
}
    public String getQty() {
        String qtyValue= getValue(QTY);
        return qtyValue;
    }
    public String getQtyInCart() {
        String qtyValueInCart= getValue(CART_QTY2);
        return qtyValueInCart;
    }
    public boolean updateCart(){
        elementExists(UPDT_BUTTON);
        clickElementByXpath(UPDT_BUTTON);
        return true;
    }
    public String getPriceText() {
        elementExists(PRICE);
        String priceValue= getText(PRICE);
        return priceValue;
    }
    public String getTotalText() {
        elementExists(TOTAL_PRICE);
        String totalValue= getText(TOTAL_PRICE);
        return totalValue;
    }
    // Use regular expression to extract only digits

    public String extractDigitsFromPrice(){

    Pattern pattern = Pattern.compile("\\d+\\.\\d+");
    Matcher matcher = pattern.matcher(getPriceText());

    StringBuilder digitsOnly = new StringBuilder();
        while (matcher.find()) {
        digitsOnly.append(matcher.group());
    }

        return digitsOnly.toString();
}public String extractDigitsFromTotal(){

    Pattern pattern = Pattern.compile("\\d+\\.\\d+");
    Matcher matcher = pattern.matcher(getTotalText());

    StringBuilder digitsOnlyTotal = new StringBuilder();
        while (matcher.find()) {
            digitsOnlyTotal.append(matcher.group());
    }

        return digitsOnlyTotal.toString();
}
}




