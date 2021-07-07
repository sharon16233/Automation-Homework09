package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Utils {
    public static final String WEB_DRIVER = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_LOCATION = "D:\\New folder\\IntelligiTest\\chromedriver.exe";
    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty(WEB_DRIVER, CHROME_DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    public static boolean FileExists(String path) {
        File tmpdir = new File(path);
        return tmpdir.exists();
    }

    @AfterAll
    public static void finish() {
        driver.quit();
    }



}
