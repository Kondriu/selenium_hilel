package Common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;


    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void endSuite() {
        driver.close();
    }
}
