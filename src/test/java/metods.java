import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


    public class metods {
        public static ChromeDriver driver;

        @Before
        public void SetUp () {
            System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
            //путь на папку ХромДрайвера
            driver = new ChromeDriver();
            //инициализация драйвера
            System.out.println("Driver started");
        }

        @After
        public void close() {
            driver.quit();
            //команда на закрытие браузера
            System.out.println("Driver stopped ");
        }

        //открыть URL
        public void openSite(String s) {
            driver.get(s);
            driver.manage().window().maximize();
        }

        //поиск элемента и клик по нему
        public void findCssClick(String s) {
            driver.findElement(By.cssSelector(s)).click();
        }

        public void findByIdAndClick(String s) {
            driver.findElement(By.id(s)).click();
        }

        public void findByXpathAndClick(String s) {
            driver.findElement(By.xpath(s)).click();
        }

        public void findByClassAndClick(String s) {
            driver.findElement(By.className(s)).click();
        }

        //поиск элемента (поля) и его заполнение
        public void findByIdAndSendKeys(String id, String keys) {
            driver.findElement(By.id(id)).sendKeys(keys);
        }

        public void findByCssAndSendKeys(String css, String keys) {
            driver.findElement(By.cssSelector(css)).sendKeys(keys);
        }

        //ожидание элемента на странице
        public void waitElmById(String id) {
            //инициализация WebDriverWait, таймаут 10 секунд
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        }

        public void waitElmByClass(String cl) {
            //инициализация WebDriverWait, таймаут 10 секунд
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(cl)));
        }


        public void waitElmByCss(String css) {
            //инициализация WebDriverWait,  таймаут 10 секунд
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        }





    }

