package test;
import driver.DriverSettings;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.SignInPage;

public class Test1 extends DriverSettings {

    @org.junit.Test
        public void Test1(){
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        HomePage.open();
        HomePage.assertTittle();
        }

    @org.junit.Test
    public void Test2() {
        SignInPage SignInPage = PageFactory.initElements(driver, page.SignInPage.class);
        SignInPage.open();
        SignInPage.waitLoginForm();
        SignInPage.clickUserName();
        SignInPage.userNameSendKeys("shprotagera@yandex.ru");
        SignInPage.clickContinueButton();
        SignInPage.waitPasswordForm();
        SignInPage.clickPassword();
        SignInPage.passwordSendKeys("TestTestTest");
        SignInPage.clickSignInButton();
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        HomePage.waitUserInfoName();
    }

    @org.junit.Test
    public void Test3() {
        SignInPage SignInPage = PageFactory.initElements(driver, page.SignInPage.class);
        SignInPage.open();
        SignInPage.waitLoginForm();
        SignInPage.clickUserName();
        SignInPage.userNameSendKeys("shprotagera@yandex.ru");
        SignInPage.clickContinueButton();
        SignInPage.waitPasswordForm();
        SignInPage.clickPassword();
        SignInPage.passwordSendKeys("TestTest");
        SignInPage.clickSignInButton();
        SignInPage.waitSingInErrorReport();

    }


}
