package Pages;

public class SomeEnglishBookPage extends BasePage{
    private static final String BOOK_NAME="//h1[contains(text(),'I Love to Go to Daycare ')]";
    private static final String FORMAT="//select[@id='SingleOptionSelector-0']";


    public boolean isBookPageHeaderVisible(){
        Boolean isVisible = elementExists(BOOK_NAME);
        return isVisible;
    }
    public boolean chooseHardcover(){
        sendTextToElementByXpath(FORMAT,"Hardcover");
        return true;
    }

}
