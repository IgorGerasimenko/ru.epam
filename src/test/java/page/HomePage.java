package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage{

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage (WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 10);
    }
//----------------------------------------------------------------------------

    @FindBy(css=".header-auth__signin")
    private WebElement signUpButton;

    @FindBy(css="#header > div.container > div.user-navigation-container" +
            " > div.header-controls > div.dropdown.user-info-desktop > a > div.user-info__name")
    private WebElement userInfoNameButton;


//----------------------------------------------------------------------------

    public void open(){
        driver.get("https://www.training.ru/");
        driver.manage().window().maximize();
     }

    public void assertTittle(){
        assertThat(driver.getTitle(), is("Тренинг-центр EPAM в России - программы обучения" +
                " для студентов, а также тех, кто хочет начать карьеру в IT | training.ru"));
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public void waitSignUpButton(){
        wait.until(ExpectedConditions.visibilityOf((signUpButton)));
    }

    public void waitUserInfoName(){
        wait.until(ExpectedConditions.visibilityOf((userInfoNameButton)));
        driver.findElement(By.linkText("shprotagera"));


    }



}
