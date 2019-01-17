package core.sportchek;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class SportchekHomePage {

    @FindBy(xpath = "//div[@id='rfk_search_container']//input")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='menu-toggle__text']")
    private WebElement buttonCategories;

    @FindBys({
            @FindBy(xpath = "//*[@class='rfk_product']//div[3]")
    })
    private List<WebElement> quickSearchResult;

    @FindBys({
            @FindBy(xpath = "//*[@class='rfk_product']//a[1]")
    })
    private List<WebElement> quickSearchResultLinks;

    @FindBys({
            @FindBy(xpath = "//ul[@class='page-nav__list page-nav__list_short main-menu']//li[@class='page-nav__item']")
    })
    private List<WebElement> shopCategories;


    private WebDriver webDriver;

    public SportchekHomePage(final WebDriver webDriver) {

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void typeSearchText(final String text) {
        searchInput.sendKeys(text);
    }

    public List<String> getQuickSearchResult() {
        final List<String> listQuickSearchResult = new ArrayList<String>();

        for (final WebElement element : quickSearchResult) {
            final String txt = element.getText();
            listQuickSearchResult.add(txt);
        }
        return listQuickSearchResult;
    }

    public List<WebElement> getQuickSearchLink() {
        final List<WebElement> listLinks = new ArrayList<WebElement>();


        for (final WebElement element : quickSearchResultLinks) {
            final WebElement link = element;
            listLinks.add(link);
        }
        return listLinks;
    }

    public ProductDetailsPage clickOnItemFromQuickSearchLink(int i) {
        getQuickSearchLink().get(i).click();
        return new ProductDetailsPage(webDriver);
    }

    public void clickCategories() {
        buttonCategories.click();
    }

    public void expandFilterBox() {
        buttonCategories.click();
    }

    //--
    public List<String> getFiltersItemsList() {
        final List<String> filterItemTextList = new ArrayList<String>();

        for (final WebElement element : shopCategories) {
            final String text = element.getText();
            filterItemTextList.add(text);
        }
        return filterItemTextList;
    }

//    @FindBy (xpath = "//h1[@class='global-page-header__title']\n")
//    private WebElement productTitle;
//
//    public String getProductTitle(){
//        final String pTitle = productTitle.getText();
//        return pTitle;
//    }


    //----домашка Register Now ----

    @FindBy(xpath = "//*[@class='header-account__trigger' and contains (text(), 'Sign In / My Account')]")
    private WebElement signInLink;

    public void clickSignIn() {
        signInLink.click();
    }

    @FindBy(xpath = "//a[@class='header-account__sign-in__register__link']")
    private WebElement registerNow;

    public void clickRegisterNow() {
        registerNow.click();
    }

    @FindBy(xpath = "//input[@type='email' and @name='login' and @placeholder='Email (e.g. name@example.com)']")
    private WebElement registerInputEmail;

    public void setRegisterInputEmail(final String inputEmail) {
        registerInputEmail.sendKeys(inputEmail);
    }

    @FindBy(xpath = "//input[@placeholder = 'Confirm Email']")
    private WebElement registerInputConfirmEmail;

    public void setRegisterInputConfirmEmail(final String confirmEmail){
        registerInputConfirmEmail.sendKeys(confirmEmail);
    }

    @FindBy(xpath = "//input[@placeholder='Password (six characters minimum)']")
    private WebElement registerInputPassword;

    public void setRegisterInputPassword(final String inputPassword){
        registerInputPassword.sendKeys(inputPassword);
    }
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement registerInputConfirmPassword;

    public void setRegisterInputConfirmPassword (final String confirmPassword){
        registerInputConfirmPassword.sendKeys(confirmPassword);
    }

    @FindBy(xpath = "//input[@id='cardNumberMainRegister']")
    private WebElement registerInputCardNumber;

    public void setRegisterInputCardNumber (final String cardNumber){
        registerInputCardNumber.sendKeys(cardNumber);
    }

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
    private WebElement registerNotRobotCaptcha;

    public void clickRegisterNotRobotCaptcha(){
        registerNotRobotCaptcha.click();
    }
    @FindBy(xpath = "//input[@class='register-form__submit button button_color_red']")
    private WebElement registerClickRegisterButton;

    public void clickRegisterClickRegisterButton(){
        registerClickRegisterButton.click();
    }


    @FindBy(xpath = "//span[@for='login' and contains (@class, 'validation-error validation-error_show')]")
    private WebElement validationErrorLogin;
    public final String expectedValidationErrorLogin = "Please enter your email address in this format: name@example.com";
    public final String expectedValidationErrorEmptyEmail = "Email is required.";

    public String getErrorMessageErrorLogin (){
        return validationErrorLogin.getText();
    }

    @FindBy(xpath = "//span[@for='loginConfirmation' and contains (@class, 'validation-error validation-error_show')]")
    private WebElement validationErrorLoginConfirmation;
    public final String expectedValidationErrorLoginConfirmation = "Email addresses must match.";

    public String getErrorMessageErrorLoginConfirmation (){
        return validationErrorLoginConfirmation.getText();
    }

    @FindBy(xpath = "//span[@for='password' and contains (@class, 'validation-error validation-error_show')]")
    private WebElement validationErrorPassword;
    public final String expectedValidationErrorPassword = "Your password must be 6-40 characters long.";
    public final String expectedValidationErrorPasswordRrequired = "Password is required.";

    public String getErrorMessageErrorPassword (){
        return validationErrorPassword.getText();
    }
    @FindBy(xpath = "//span[@for='confirmPassword' and contains (@class, 'validation-error validation-error_show')]")
    private WebElement validationErrorConfirmPassword;
    public final String expectedValidationErrorConfirmPassword = "Passwords must match.";

    public String getErrorMessageErrorConfirmPassword (){
        return validationErrorConfirmPassword.getText();
    }

    @FindBy(xpath = "//span[@for='cardNumberMainRegister' and contains (@class, 'validation-error validation-error_show')]")
    private WebElement validationErrorCardNumberMainRegister;
    public final String expectedValidationErrorCardNumberMainRegister = "Please verify Triangle Rewards™ Account number and try again";

    public String getErrorMessageErrorCardNumberMainRegister (){
        return validationErrorCardNumberMainRegister.getText();
    }

    @FindBy (xpath = "//span[@for='confirmPassword']")
    private WebElement validationCaptchaErrorMessage;
    public String expectedValidationCaptchaErrorMessage = "Please enter captcha";

    public String getExpectedValidationCaptchaErrorMessage(){
        return validationCaptchaErrorMessage.getText();
    }



    //--------------------урок 4 ----
    @FindBy(xpath = "(//li[@class='rfk_product'])[1]//a")
    private WebElement firstPickedJustForYouItem;


    public ProductDetailsPage selectFirstElementFromThePickedJustForYouSection() {
        firstPickedJustForYouItem.click();
        return new ProductDetailsPage(webDriver);

    }



}
