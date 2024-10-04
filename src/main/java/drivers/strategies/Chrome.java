package drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {
    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //tells Selenium where the ChromeDriver executable is located.
        // ChromeOptions is used to modify Chrome settings, like disabling the automation extension and adding arguments (--no-sandbox).
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options); // returns a new ChromeDriver object with these options.
    }
}
