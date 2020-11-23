package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement passWord;

    @FindBy(id="kc-login")
    private WebElement signInButton;

    @FindBy(css="#alert-error > span > span")
    private WebElement signInErrorReport;

//----------------------------------------------

    public SignInPage open(){
        driver.get("https://www.training.ru/");
        driver.manage().window().maximize();
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        HomePage.clickSignUpButton();
        return this;
    }

    public SignInPage waitLoginForm(){
        wait.until(ExpectedConditions.visibilityOf((continueButton)));
        return this;
    }

    public SignInPage waitPasswordForm(){
        wait.until(ExpectedConditions.visibilityOf((passWord)));
        return this;
    }

    public SignInPage waitSingInErrorReport(){
        wait.until(ExpectedConditions.visibilityOf((signInErrorReport)));
        return this;
    }

    public SignInPage clickUserName(){
        userName.click();
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

    public SignInPage userNameSendKeys(String username){
        userName.sendKeys(username);
        return this;
    }

    public SignInPage passwordSendKeys(String password){
        passWord.sendKeys(password);
        return this;
    }


    }
