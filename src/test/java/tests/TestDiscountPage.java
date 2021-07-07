package tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DiscountBankPage;
import utils.Utils;

public class TestDiscountPage extends Utils {

    public static DiscountBankPage discountBankPage;
    public static String baseUrl = "https://www.discountbank.co.il/DB/private";

    @BeforeEach
    public void initPage() {
        discountBankPage = new DiscountBankPage(driver);
        driver.get(baseUrl);
    }

    @Test
    public void actionsTest() throws InterruptedException {
        discountBankPage.hoverOnLoans();
        Thread.sleep(3000);
        Assert.assertTrue(discountBankPage.isSpecialLoanButtonDisplayed());
    }

}
