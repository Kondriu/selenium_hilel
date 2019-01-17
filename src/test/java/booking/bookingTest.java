package booking;

import Common.BaseTest;
import core.booking.BookingHomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class bookingTest extends BaseTest {

    //@Test
    public void checkBookingSearcj(){
        WebDriver driver = getDriver();
        driver.get("https://www.booking.com/index.en-gb.html");
        final BookingHomePage homePage = new BookingHomePage(driver);

        homePage.clickCal();
        homePage.searchForMonthAndYear("February 2019");
        homePage.selectDay("11");
        
    }
}
