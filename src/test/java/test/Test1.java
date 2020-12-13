package test;
import driver.DriverSettings;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.SignInPage;

import static org.junit.Assert.assertTrue;

public class Test1 extends DriverSettings {

    @Test
    public void openHPAndAssertThatTittleIsCorect(){
          homePage.open()
                  .assertThatTittleIsCorrect();
    }

    @Test
    public void LoginWithValidValues() {
        signInPage.open()
                  .waitLoginForm()
                  .clickUserName()
                  .userNameSendKeys("shprotagera@yandex.ru")
                  .clickContinueButton()
                  .waitPasswordForm()
                  .clickPassword()
                  .passwordSendKeys("TestTestTest")
                  .clickSignInButton();
        homePage.assertThatUserInfoNameIsDisplayed();
    }

    @Test
    public void LoginWithInvalidPass() {
        signInPage.open()
                  .waitLoginForm()
                  .clickUserName()
                  .userNameSendKeys("shprotagera@yandex.ru")
                  .clickContinueButton()
                  .waitPasswordForm()
                  .clickPassword()
                  .passwordSendKeys("TestTest")
                  .clickSignInButton()
                  .assertThatSingInErrorReportIsDisplayed();
    }

    @Test
    public void LoginWithInvalidLogin() {
        signInPage.open()
                .waitLoginForm()
                .clickUserName()
                .userNameSendKeys("Invalid@Invalid.ru")
                .clickContinueButton()
                .waitPasswordForm()
                .clickPassword()
                .passwordSendKeys("TestTestTest")
                .clickSignInButton()
                .assertThatSingInErrorReportIsDisplayed();
    }



}
