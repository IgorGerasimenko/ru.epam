package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverSettings {

    public WebDriver driver;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Driver started");
        }

    @After
    public void close() {
        driver.quit();
        System.out.println("Driver stopped ");
    }

}
