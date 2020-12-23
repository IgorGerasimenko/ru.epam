package tests;
import driver.DriverSettings;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.HomePage;
import page.SignInPage;

import javax.swing.text.Element;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AutorizationTests extends DriverSettings {

    public WebDriverWait wait;
    public WebElement element;


    @Test
    public void openHPAndAssertThatTittleIsCorect(){
          homePage.open()
                  .assertThatTittleIsCorrect();
    }

    @Test
    public void LoginWithValidValues() {
        signInPage.open()
                  .clickUserName()
                  .userNameSendKeys("shprotagera@yandex.ru")
                  .clickContinueButton()
                  .clickPassword()
                  .passwordSendKeys("TestTestTest")
                  .clickSignInButton();
        homePage.assertThatUserInfoNameIsDisplayed();
    }

    @Test
    public void LoginWithInvalidPass() {
        signInPage.open()
                  .clickUserName()
                  .userNameSendKeys("shprotagera@yandex.ru")
                  .clickContinueButton()
                  .clickPassword()
                  .passwordSendKeys("TestTest")
                  .clickSignInButton()
                  .assertThatSingInErrorReportIsDisplayed();
    }

    @Test
    public void LoginWithInvalidLogin() {
        signInPage.open()
                .clickUserName()
                .userNameSendKeys("Invalid@Invalid.ru")
                .clickContinueButton()
                .clickPassword()
                .passwordSendKeys("TestTestTest")
                .clickSignInButton()
                .assertThatSingInErrorReportIsDisplayed();
    }

    @Test
    public void LoginWithNoValidLoginFormat() {
        signInPage.open()
                .clickUserName()
                .userNameSendKeys("InvalidEmailFormat")
                .assertThatContinueButtonIsNotActive();

    }

//        @Test
//        public void Kosmoport() {
//        driver.get("https://kosmoport.comfortkino.ru/");
//        element = driver.findElement(By.xpath("//*[text()='Кинобонус']"));
//            assertTrue(element.isDisplayed());
//
//    }

}
