package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

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

    public HomePage open(){
        driver.get("https://www.training.ru/");
        driver.manage().window().maximize();
        return this;
     }

    public HomePage assertThatTittleIsCorrect(){
        assertThat(driver.getTitle(), is("Тренинг-центр EPAM в России - программы обучения" +
                " для студентов, а также тех, кто хочет начать карьеру в IT | training.ru"));
        return this;
    }

    public HomePage clickSignUpButton() {
        signUpButton.click();
        return this;
    }

    public HomePage waitSignUpButton() {
        wait.until(ExpectedConditions.visibilityOf((signUpButton)));
        return this;
    }

//    public HomePage waitUserInfoName(){
//        wait.until(ExpectedConditions.visibilityOf((userInfoNameButton)));
//        return this;
//
//    }

    public HomePage assertThatUserInfoNameIsDisplayed(){
        assertTrue(userInfoNameButton.isDisplayed() );
        return this;

    }

}
