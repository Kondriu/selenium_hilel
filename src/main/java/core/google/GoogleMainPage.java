package core.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    private WebDriver webDriver; //просто обявили еще один обект с навзванием webDriver, который требует SearchResultPage.
                                 // а требует он потомуу что в конструкторе класса SearchResultPage
                                 //  задано требовать (final WebDriver webDriver). здесь обявили элемент обекта.
                                 // а проинициализирован он будет в конструкторе этого класса GoogleMainPage

    private WebDriverWait webDriverWait;
    private final static Long ELEMENT_WAIT_TIME_OUT = 30L;

    public GoogleMainPage(final WebDriver webDriver){
        this.webDriver = webDriver; //здесь на обявили что webDriver обявленный в этом классе (обозначенный this) это то-же
                                    // самое что и "глобальный" webDriver.
                                    // и таким образом проинициализровали?
        webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT);
        PageFactory.initElements(webDriver, this);

    }


    public SearchResultPage typeSearchText(final String text){
        searchInput.sendKeys(text, Keys.ENTER);
        return new SearchResultPage(webDriver);
    }

    public String getExpectedOkButtonText(){
        return searchButton.getText();
    }

//возвращает нов страницу с результатами
    public SearchResultPage clickSearchButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new SearchResultPage(webDriver);
    }

}
