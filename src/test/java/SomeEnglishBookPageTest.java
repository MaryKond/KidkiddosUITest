import Pages.SomeEnglishBookPage;
import Pages.EnglishOnlyPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeEnglishBookPageTest extends UseCaseBase {
    private static EnglishOnlyPage englishOnlyPage;
    private static MainPage mainPage;
    private static SomeEnglishBookPage englishBookPage;
    private int priceForOne;


    @BeforeAll
    public static void classSetUp() {
        englishOnlyPage = new EnglishOnlyPage();
        mainPage = new MainPage();
        englishBookPage = new SomeEnglishBookPage();

    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToToMainPage();
        mainPage.navigateEnglishOnlyPage();

    }

    @Test
    public void clickOnBook() {
        englishOnlyPage.isBookNameVisible();

        //englishOnlyPage.closePopUpWindow();

        englishOnlyPage.clickOnBook();

        Boolean exist = englishBookPage.isBookPageHeaderVisible();
        assertTrue(exist);


//LOCATING THE FORMAT FIELD
        Boolean format = englishBookPage.locateFormat();
        assertTrue(format);
        englishOnlyPage.closePopUpWindow();
//CHANGING FORMAT TO HARDCOVER
        englishBookPage.chooseHardcover();
        //VERIFYING CORRECT FORMAT
        String value = englishBookPage.getFormatName();
        assertEquals("Hardcover", value);
//CHANGING Q-TY OF THE BOOK
        englishBookPage.chooseNewQty();
        String quantity = englishBookPage.getQty();
        assertEquals("5", quantity);
//ADDING BOOKS TO THE CART
        englishBookPage.clickAddToCart();

        Boolean pageExist = englishBookPage.isPageTitleVisible();
        englishOnlyPage.closePopUpWindow();
        assertTrue(pageExist);
//CHANGING QTY OF BOOKS IN CART
        englishBookPage.NewQtyCart();
        String quantityInCart = englishBookPage.getQtyInCart();
        assertEquals("6", quantityInCart);
        //englishOnlyPage.closePopUpWindow();

//UPDATING THE CART
        englishBookPage.updateCart();
        //englishOnlyPage.closePopUpWindow();
//VERIFYING THE UPDATED PRICE FOR THE NEW Q-TY OF BOOKS
        //String booksInCart = englishBookPage.getQtyInCart();

        int qty = Integer.parseInt(quantityInCart);
        String priceText = englishBookPage.extractDigitsFromPrice();
        String totalText = englishBookPage.extractDigitsFromTotal();


        double priceNum = Double.parseDouble(priceText);
        double totalNum = Double.parseDouble(totalText);

        double total = priceNum * qty;
        assertEquals(total, totalNum);

    }

}







