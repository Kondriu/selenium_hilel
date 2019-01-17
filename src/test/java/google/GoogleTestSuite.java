package google;

import Common.BaseTest;
import core.google.GoogleMainPage;
import core.google.SearchResultPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class GoogleTestSuite extends BaseTest {

//    private WebDriver driver;
//
//    @Before
//    public void setDriver(){
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//    }
//
//    @After
//    public void driverClose(){
//        driver.close();
//    }

    @Test
    public void checkGoogleMainPageIsOpen() {
        final WebDriver driver = getDriver();
        final String expectedTittle = "Google";
        driver.get("https://google.com");
        final String actualTitle = driver.getTitle();
//        System.out.println(expectedTittle);
//        System.out.println(actualTitle);
        Assert.assertEquals("error message: Incorrect page title!", expectedTittle, actualTitle);
    }

    @Test
    public void checkGoogleSearch() {
        final WebDriver driver = getDriver();
        final String expectedResultFirstLinkTest = "Компьютерная школа Hillel в Киеве: курсы IT технологий";

        //1. открыли главнусю стр google
        driver.get("https://google.com");

        //2. создаем обьект главной страницы google
        final GoogleMainPage page = new GoogleMainPage(driver);

        //3. вводим искомое слово в поисковик
        final SearchResultPage searchResultPage = page.typeSearchText("Hillel");

        //4. возвращаем новую страницу с результатами поиска
        //page.clickSearchButton();

        //5. Получаем текст первой ссылки
        final String actualFirstLinkText = searchResultPage.getFirstSearchResultLinkText();

        // сравниваем
        Assert.assertEquals("There incorrect first link displayed", expectedResultFirstLinkTest, actualFirstLinkText);


    }
}
