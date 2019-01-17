package core.sportchek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProductDetailsPage {

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    private Actions actions;

    private Integer productQtyBeforeCart;

    public Integer getProductQtyBeforeCart() {
        return productQtyBeforeCart;
    }


    @FindBy (xpath = "//h1[@class='global-page-header__title']\n")
    private WebElement productTitle;

    @FindBy(xpath = "//select[@data-control-type='size']")
    private WebElement selectSizeDropdown;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement selectQty;

    @FindBy(xpath = "//button[@class='add-cart product-detail__button product-detail__button-icon']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='header-cart__trigger drawer-ui__toggle']")
    private WebElement mimiCartItemsCount;

    //@FindBy(xpath = "//section[@class='cart-item']/a[@data-action='goToProductDetailsPage']")
    //section[@class='cart-item']//h2/a[@data-action='goToProductDetailsPage']
    @FindBy(xpath = "//section[@class='cart-item']//h2/a[@data-action='goToProductDetailsPage']")
    private WebElement miniCartPopupTitle;

    @FindBy(xpath = "//dd[@class='cart-item__detail__description']")
    private WebElement qty;


    public ProductDetailsPage(final WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30); //не должен быть нулл. идем в метод где надо погодить и там исп. (аддТуКардБаттон)
        actions = new Actions(webDriver);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }

    public String getProductTitle(){
        final String pTitle = productTitle.getText();
        return pTitle;
    }

    public void selectProductSize(final int productSizeIndex){
        //webDriverWait.until(ExpectedConditions.);
        final Select selectSize = new Select(selectSizeDropdown); // готовый библиотечный класс. уже реализованный мы просто его заюзали.
        //обявили экземплаяр класса select. сказали ему с каким  именно селектом ему работать. передали в переменной  selectSizeDropdown
        //Select хороший класс. надо почитать. для наших форм будет полезным.
        selectSize.selectByIndex(productSizeIndex);
    }

    public void selectProductQty(final  int productQtyIndex){
        final Select productQtuSel= new Select(selectQty);
        productQtuSel.selectByIndex(productQtyIndex);
        final  String productQtyBeforeCartText = productQtuSel.getFirstSelectedOption().getText();
        productQtyBeforeCart = Integer.parseInt(productQtyBeforeCartText);
    }

    public void clickAddToCartButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        //вставлять этот вейт там где хочеться всатвлять тредСлип. тредСлип это плохо.
        addToCartButton.click();
    }

    public String getMiniCardPopupTitle (){
        actions.moveToElement(mimiCartItemsCount).perform();
        //мало навсети мышкой. но надо еще вызвать метод perform чтобы "закрепить" наведение.
        return miniCartPopupTitle.getText();
    }

    public Integer getMiniCartPopupQty(){
        actions.moveToElement(mimiCartItemsCount).perform();
        final String prodQty = qty.getText();
        return Integer.parseInt(prodQty);
    }


}
