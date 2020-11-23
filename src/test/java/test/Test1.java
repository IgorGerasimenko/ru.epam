package test;
import driver.DriverSettings;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.SignInPage;

public class Test1 extends DriverSettings {

    @org.junit.Test
    public void Test1(){
          homePage.open()
                  .assertTittle();
    }

    @org.junit.Test
    public void Test2() {
        signInPage.open()
                  .waitLoginForm()
                  .clickUserName()
                  .userNameSendKeys("shprotagera@yandex.ru")
                  .clickContinueButton()
                  .waitPasswordForm()
                  .clickPassword()
                  .passwordSendKeys("TestTestTest")
                  .clickSignInButton();
        homePage.waitUserInfoName();
    }

    @org.junit.Test
    public void Test3() {
        signInPage.open()
                  .waitLoginForm()
                  .clickUserName()
                  .userNameSendKeys("shprotagera@yandex.ru")
                  .clickContinueButton()
                  .waitPasswordForm()
                  .clickPassword()
                  .passwordSendKeys("TestTest")
                  .clickSignInButton()
                  .waitSingInErrorReport();

    }


}
