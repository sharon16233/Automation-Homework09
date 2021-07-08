package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscountBankPage extends BasePage {

    /*************Elements*****************/

    @FindBy(css = "[href='/DB/private/credit']")
    WebElement loansButton;

    @FindBy(css = "[href='/DB/private/credit/loans/special-loans']")
    WebElement specialLoanOfferButton;


    /*************Methods*****************/

    public void hoverOnLoans() {
        hoverOnElement(loansButton);
    }

    public boolean isSpecialLoanButtonDisplayed() {
        return isElementDisplayed(specialLoanOfferButton);
    }

    /*************Constructor*****************/

    public DiscountBankPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
