package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

//----------------------------------------------

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="kc-login-next")
    private WebElement continueButton;

    @FindBy(id="password")
    private WebElement passWord;

    @FindBy(id="kc-login")
    private WebElement signInButton;

    @FindBy(css="#alert-error > span > span")
    private WebElement signInErrorReport;

    @FindBy(css=".header-auth__signin")
    private WebElement signUpButton;

//----------------------------------------------

    public SignInPage open(){
        driver.get("https://www.training.ru/");
        driver.manage().window().maximize();
        signUpButton.click();
        return this;
    }

    public SignInPage clickUserName(){
        username.click();
        return this;
    }

    public SignInPage clickPassword(){
        passWord.click();
        return this;
    }

    public SignInPage clickContinueButton(){
        continueButton.click();
        return this;
    }

    public SignInPage clickSignInButton(){
        signInButton.click();
        return this;
    }

    public SignInPage userNameSendKeys(String login){
        username.sendKeys(login);
        return this;
       }

    public SignInPage passwordSendKeys(String password){
        passWord.sendKeys(password);
        return this;
    }

    public SignInPage assertThatSingInErrorReportIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf((signInErrorReport)));
        assertTrue(signInErrorReport.isDisplayed());
        return this;
    }

    public SignInPage assertThatContinueButtonIsNotActive(){
        assertFalse(continueButton.isEnabled());
        return this;
    }




    }
