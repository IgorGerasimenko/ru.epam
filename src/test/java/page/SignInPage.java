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

    @FindBy(css="#alert-error > div.alert-summary")
    private WebElement signInErrorReport;


//----------------------------------------------

    public void open(){
        driver.get("https://www.training.ru/");
        driver.manage().window().maximize();
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        HomePage.clickSignUpButton();
    }

    public void waitLoginForm(){
        wait.until(ExpectedConditions.visibilityOf((continueButton)));
    }

    public void waitPasswordForm(){
        wait.until(ExpectedConditions.visibilityOf((passWord)));
    }

    public void waitSingInErrorReport(){
        wait.until(ExpectedConditions.visibilityOf((signInErrorReport)));
    }

    public void clickUserName(){
        userName.click();
    }

    public void clickPassword(){
        passWord.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void userNameSendKeys(String username){
        userName.sendKeys(username);
    }

    public void passwordSendKeys(String password){
        passWord.sendKeys(password);
    }



    }
