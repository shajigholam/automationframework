package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement zipcode;

    @FindBy(id = "billing_town")
    private WebElement townName;

    @FindBy(id = "billing_postcode")
    private WebElement zipCode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(css = "#post-207 > content > div > div.woocommerce > div > p")
    private WebElement lastMessage;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span > bdi")
    private WebElement totalAmount;

    @FindBy(id = "place_order")
    private WebElement placeOrder;

    @FindBy(css = "#post-207 > header > h1")
    private WebElement orderStatus;

    public void provideBillingDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(address));
        address.sendKeys("abc");
    }

    public void providePersonalDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(address));
        firstName.sendKeys("Laurentiu");
        lastName.sendKeys("Raducu");
        address.sendKeys("abc");
        zipCode.sendKeys("8000");
        city.sendKeys("Zurich");
        email.sendKeys("laurentiu@bitheap.tech");
    }

    public String getTotalAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return totalAmount.getText();
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrder);
        wait.until(ExpectedConditions.visibilityOf(lastMessage));
    }

    public String getOrderStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(orderStatus));
        return orderStatus.getText();
    }

}
