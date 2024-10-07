package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu-item-2330 > a")
    private WebElement signInButton;

    @FindBy(id = "menu-item-1310")
    private WebElement shopButton;

    @FindBy(css = "#menu-item-2333 > a")
    private WebElement username;

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void clickShopButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(shopButton));
        shopButton.click();
    }

    public String getUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(username));
        return username.getText();
    }

    /*
    // to use screenshot method when there is a sth wrong
    public void addFirstElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirst.click();
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        if (cart.getText().contains(Constants.CART_QUANTITY)) {
            System.out.println("cart has been updated");
            Utils.takeScreenshot();
        }
        else {
            System.out.println("cart has not been updated");

        }
    }

     */

}
