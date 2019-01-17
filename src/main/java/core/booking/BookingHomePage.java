package core.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHomePage {

    @FindBy(xpath = "//btn")
    private WebElement elementLang;

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement destination;

    @FindBy(xpath = "//div[@data-calendar2-title='Check-in']")
    private WebElement openCalendar;

    @FindBy(xpath = "//label[@id='xp__guests__toggle']")
    private WebElement guests;

    @FindBy(xpath = "//button[@data-sb-id='main']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    private WebElement calendarNextDateButton;

    private static final String CURENT_MONTH_YEAR = "(//div[@class='bui-calendar__month'])[1]";

    private static final String CURRENT_DAYS = "//div[@class='bui-calendar__wrapper'][1]//td[@data-bui-ref='calendar-date' and contains(@data-date, '%s')]";

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public BookingHomePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, 30);
    }

    public void searchForMonthAndYear(final String monthAndYear){


        while (!webDriver.findElement(By.xpath(CURENT_MONTH_YEAR)).getText().equalsIgnoreCase(monthAndYear)){

            calendarNextDateButton.click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(calendarNextDateButton));



//            final WebElement currentMonthAndYear = webDriver.findElement(By.xpath(CURENT_MONTH_YEAR));
//            currentMOnthAndYearText = currentMonthAndYear.getText();
        }
    }

    public void selectDay(final String expectedDay){
        final String fullDayByLokator = String.format(CURRENT_DAYS, expectedDay);
        final WebElement reqDay = webDriver.findElement(By.xpath(fullDayByLokator));
        reqDay.click();

    }
    public void clickCal(){
        openCalendar.click();
    }

}
