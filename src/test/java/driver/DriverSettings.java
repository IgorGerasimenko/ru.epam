package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePage;
import page.SignInPage;


public class DriverSettings {

    public WebDriver driver;
    public HomePage homePage;
    public SignInPage signInPage;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Driver started");
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, page.SignInPage.class);
        }

    @After
    public void close() {
        driver.quit();
        System.out.println("Driver stopped ");
    }



}
