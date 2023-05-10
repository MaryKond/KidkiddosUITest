package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishOnlyPage extends BasePage {
    private static final String ENGLISH_ONLY_HEADER = "//h1[text()='English Only']";

    public boolean isTitleVisible() {
        return elementExists(ENGLISH_ONLY_HEADER);
    }

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
