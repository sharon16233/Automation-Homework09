package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuruPage extends BasePage {

    /*************Elements*****************/

    @FindBy(name = "uid")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    @FindBy(id = "message23")
    WebElement badUsernameText;

    @FindBy(id = "message18")
    WebElement badPasswordText;

    @FindBy(linkText = "SEO")
    WebElement SEOButton;

    @FindBy(xpath = "//a[contains(text(),'Page-6')]")
    WebElement pageSixButton;

    @FindBy(css = "[class='nav navbar-nav']")
    WebElement barAfterLogin;


    /*************Methods*****************/

    public void inputUsername(String username) {
        inputText(userNameField, username);
    }
    public void inputPassword(String password) {
        inputText(passwordField, password);
    }
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
    public void clickOnUsernameField() {
        clickOnElement(userNameField);
    }
    public void clickOnPasswordField() {
        clickOnElement(passwordField);
    }
    public boolean usernameTextExists(String expected) {
        return expected.equals(badUsernameText.getText());
    }
    public boolean passwordTextExists(String expected) {
        return expected.equals(badPasswordText.getText());
    }

    public boolean isAlertTextCorrect(String alertText) {
        return alertText.equals(driver.switchTo().alert().getText());
    }

    public boolean isLoginSuccessful() {
        return isElementDisplayed(barAfterLogin);
    }

    public void clickOnSEOButton() {
        clickOnElement(SEOButton);
    }

    public void clickOnPageSixButton() {
        clickOnElement(pageSixButton);
    }

    public boolean isGoToPageSixSuccessful() {
        return driver.getTitle().equals("SEO Demo Page-6");
    }


    /*************Constructor*****************/

    public GuruPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
