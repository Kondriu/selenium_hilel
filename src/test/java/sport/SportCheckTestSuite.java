package sport;

import Common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import core.sportchek.ProductDetailsPage;
import core.sportchek.SportchekHomePage;

import java.util.ArrayList;
import java.util.List;

public class SportCheckTestSuite extends BaseTest {

    //final WebDriver driver = getDriver();

    //@Test
    public void searchNike() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.typeSearchText("Nike");
        ArrayList actualSearchResults = (ArrayList) page.getQuickSearchResult();

        final String secondItem = actualSearchResults.get(1).toString();
        System.out.println("look for:\t" + secondItem);

        final ProductDetailsPage pageProduct = page.clickOnItemFromQuickSearchLink(1);
        final String pTitle = pageProduct.getProductTitle();
        System.out.println("found:\t\t" + pTitle);

        Assert.assertEquals("wrong title", secondItem, pTitle);
    }

    //@Test
    public void clickCategories() {
        final WebDriver driver = getDriver();
        final String[] expectedFilterItemsArray = {"Deals & Features", "Men", "Women", "Kids", "Shoes & Footwear", "Gear", "Electronics", "Jerseys & Fan Wear", "Sneaker Launches", "Shop by Brand", "Chek advice"};

        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickCategories();
        //final ArrayList actualArray = (ArrayList) page.getFiltersItemsList();
        final List<String> actualFilerItem = page.getFiltersItemsList();
        Assert.assertArrayEquals("Error message", expectedFilterItemsArray, actualFilerItem.toArray());

    }

    @Test
    public void checkMiniCardProductInfo() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        final ProductDetailsPage productDetailsPage = page.selectFirstElementFromThePickedJustForYouSection();
        productDetailsPage.selectProductQty(1);
        productDetailsPage.selectProductSize(1);
        productDetailsPage.clickAddToCartButton();

        final String productTitleBeforeCart = productDetailsPage.getProductTitle();
        final String productTitleAfterCart = productDetailsPage.getMiniCardPopupTitle();
        System.out.println(productTitleAfterCart+"\n"+productTitleBeforeCart);

        final Integer actualQty = productDetailsPage.getMiniCartPopupQty();
        final Integer productQtyBeforeCart = productDetailsPage.getProductQtyBeforeCart();

        Assert.assertEquals("эрроро", productTitleBeforeCart, productTitleAfterCart);

        System.out.println( productQtyBeforeCart +"\n"+ actualQty);
        Assert.assertEquals("wrong qty", productQtyBeforeCart, actualQty);
    }





    // --------homework 03----
    //@Test
    public void checkRegistryEmailErrorMessage() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("asdf");
        page.setRegisterInputConfirmEmail("asdf");
        page.setRegisterInputPassword("12345678");
        page.setRegisterInputConfirmPassword("12345678");
        page.setRegisterInputCardNumber("2193884825");//636574 2193884825
        //page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorLogin();
        System.out.println(page.expectedValidationErrorLogin);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorLogin, actualMessage);
    }

    //@Test
    public void checkRegistryEmptyEmailErrorMessage() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("");
        page.setRegisterInputConfirmEmail("name@example.com");
        page.setRegisterInputPassword("12345678");
        page.setRegisterInputConfirmPassword("12345678");
        page.setRegisterInputCardNumber("2193884825");//636574 2193884825
        //page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorLogin();
        System.out.println(page.expectedValidationErrorEmptyEmail);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorEmptyEmail, actualMessage);
    }

   // @Test
    public void checkRegistryConfirmEmailErrorMessage() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("name@example.com");
        page.setRegisterInputConfirmEmail("tname@example.com");
        page.setRegisterInputPassword("12345678");
        page.setRegisterInputConfirmPassword("12345678");
        page.setRegisterInputCardNumber("2193884825");//636574 2193884825
        //page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorLoginConfirmation();
        System.out.println(page.expectedValidationErrorLoginConfirmation);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorLoginConfirmation, actualMessage);
    }

    //@Test
    public void checkRegistryPasswordErrorMessagePasswordRequired() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("name@example.com");
        page.setRegisterInputConfirmEmail("name@example.com");
        page.setRegisterInputPassword("");
        page.setRegisterInputConfirmPassword("");
        page.setRegisterInputCardNumber("2193884825");//636574 2193884825
        //page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorPassword();
        System.out.println(page.expectedValidationErrorPasswordRrequired);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorPasswordRrequired, actualMessage);
    }

    //@Test
    public void checkRegistryPasswordErrorMessagePassword() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("name@example.com");
        page.setRegisterInputConfirmEmail("name@example.com");
        page.setRegisterInputPassword("123");
        page.setRegisterInputConfirmPassword("123");
        page.setRegisterInputCardNumber("2193884825");//636574 2193884825
        //page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorPassword();
        System.out.println(page.expectedValidationErrorPassword);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorPassword, actualMessage);
    }

    //@Test
    public void checkRegistryPasswordErrorMessageConfirmPassword() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("name@example.com");
        page.setRegisterInputConfirmEmail("name@example.com");
        page.setRegisterInputPassword("12345678");
        page.setRegisterInputConfirmPassword("1234567890");
        page.setRegisterInputCardNumber("2193884825");
        //page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorConfirmPassword();
        System.out.println(page.expectedValidationErrorConfirmPassword);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorConfirmPassword, actualMessage);
    }

    //@Test
    public void checkRegistryCardNumberErrorMessage() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("name@example.com");
        page.setRegisterInputConfirmEmail("name@example.com");
        page.setRegisterInputPassword("12345678");
        page.setRegisterInputConfirmPassword("12345678");
        page.setRegisterInputCardNumber("1193884833"); //1193884825
        page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getErrorMessageErrorCardNumberMainRegister();
        System.out.println(page.expectedValidationErrorCardNumberMainRegister);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationErrorCardNumberMainRegister, actualMessage);
    }

    //@Test
    public void checkRegistryCaptchaErrorMessage() {
        final WebDriver driver = getDriver();
        driver.get("https://www.core.sportchek.ca/");
        final SportchekHomePage page = new SportchekHomePage(driver);
        page.clickSignIn();
        page.clickRegisterNow();
        page.setRegisterInputEmail("name@example.com");
        page.setRegisterInputConfirmEmail("name@example.com");
        page.setRegisterInputPassword("12345678");
        page.setRegisterInputConfirmPassword("12345678");
        page.setRegisterInputCardNumber("1193884825"); //1193884825
        page.clickRegisterClickRegisterButton();
        final String actualMessage = page.getExpectedValidationCaptchaErrorMessage();
        System.out.println(page.expectedValidationCaptchaErrorMessage);
        System.out.println(actualMessage);
        Assert.assertEquals("эррорро", page.expectedValidationCaptchaErrorMessage, actualMessage);
    }

}

