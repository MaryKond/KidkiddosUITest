package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishOnlyPage extends BasePage {
    private static final String ENGLISH_ONLY_HEADER = "//h1[text()='English Only']";
    private static final String BOOK_TITLE="//a[@class='grid-view-item__link'and contains(@href,'/i-love-to-go-to-daycare')]";

    public boolean isTitleVisible() {
        return elementExists(ENGLISH_ONLY_HEADER);
    }


    public boolean isBookNameVisible() {
        return elementExists(BOOK_TITLE);
    }

    public SomeEnglishBookPage clickOnBook(){
        clickElementByXpath(BOOK_TITLE);
        return new SomeEnglishBookPage();
    }

//    public boolean bookExists(){
//        return elementExists(BOOK_TITLE);
//    }


    public boolean closePopUpWindow() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='_close-icon']")));

            clickElementByXpath("//i[@class='_close-icon']");
            return true;
        } catch (Exception err) {
            return false;
        }
    }


}
