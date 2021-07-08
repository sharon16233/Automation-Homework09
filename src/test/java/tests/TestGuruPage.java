package tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.GuruPage;
import utils.Utils;


public class TestGuruPage extends Utils {

    public static GuruPage guruPage;
    public static String baseUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    public static String invalidUsername = "1111";
    public static String invalidPassword = "1111";
    public static String validUsername = "1303";
    public static String validPassword = "Guru99";
    public static String expectedBadUsernameText = "User-ID must not be blank";
    public static String expectedBadpasswordText = "Password must not be blank";
    public static String expectedAlertText = "User or Password is not valid";

    @BeforeEach
    public void initPage() {
        guruPage = new GuruPage(driver);
        driver.get(baseUrl);
    }

    @Test
    public void badLoginTest() throws InterruptedException {
        guruPage.inputUsername(invalidUsername);
        guruPage.inputPassword(invalidPassword);
        guruPage.clickOnLoginButton();

        Assert.assertTrue(guruPage.isAlertPresent());
        Assert.assertTrue(guruPage.isAlertTextCorrect(expectedAlertText));
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void validationMessagesTest() {
        guruPage.clickOnUsernameField();
        guruPage.pressOnKeyboard(Keys.ESCAPE);
        guruPage.clickOnPasswordField();
        guruPage.pressOnKeyboard(Keys.ESCAPE);

        Assert.assertTrue(guruPage.usernameTextExists(expectedBadUsernameText));
        Assert.assertTrue(guruPage.passwordTextExists(expectedBadpasswordText));
    }

    @Test
    public void goodLoginTest() {
        guruPage.inputUsername(validUsername);
        guruPage.inputPassword(validPassword);
        guruPage.clickOnLoginButton();
        Assert.assertTrue(guruPage.isLoginSuccessful());

        guruPage.clickOnSEOButton();
        guruPage.clickOnPageSixButton();
        Assert.assertTrue(guruPage.isGoToPageSixSuccessful());
    }

}
