import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Constants;
import utils.FrameworkProperties;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;
    static ShopPage shopPage;
    static CartPage cartPage;

    @BeforeClass
    public static void initializeObjects(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        shopPage = new ShopPage();
        checkoutPage = new CheckoutPage();
        cartPage = new CartPage();
    }

    @Test
    public void testingAuthentication(){
        driver.get(Constants.URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUsername());
    }
    @Test
    public void testingAddingThingsToCart(){
        driver.get(Constants.URL);
        homePage.clickShopButton();
        shopPage.goToThirdPage();
        shopPage.addElementToCart();
        assertEquals(Constants.CART_QUANTITY, shopPage.getNumberOfProducts());
    }

    @Test
    public void testingTheFullBuyingProcess(){
        driver.get(Constants.URL);
        homePage.clickShopButton();
        shopPage.goToThirdPage();
        shopPage.addElementToCart();
        shopPage.proceedToCheckout();
        cartPage.proceedToCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.providePersonalDetails();
        checkoutPage.placeOrder();
        assertEquals("Order received", checkoutPage.getOrderStatus());
    }

    @AfterClass
    public static void closeObjects(){
        driver.close();
    }
}
