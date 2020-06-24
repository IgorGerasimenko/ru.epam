import org.junit.Assert;
import org.junit.Test;

public class test extends metods{

    @Test
    public void Test1() {
        openSite("https://www.training.ru/");
        String title = driver.getTitle();
        //запросили тайтл
        Assert.assertTrue(title.equals("Тренинг-центр EPAM в России - программы обучения для студентов, а также тех, кто хочет начать карьеру в IT | training.ru"));
        //Асерт-проверка предположения, в данном случае, что имя страницы соответсвует значению
    }


    @Test
    public void Test2() {
        //Залогиниться (валидые значения)
        openSite("https://www.training.ru/");
        findByClassAndClick("header-auth__signin");
        waitElmById("kc-content");
        findByIdAndSendKeys("username", "shprotagera@yandex.ru");
        findByIdAndSendKeys("password", "TestTestTest");
        findByIdAndClick("kc-login");
        waitElmByCss("#header > div.container > div.user-navigation-container > div.header-controls > div.dropdown.user-info-desktop > a > div.user-info__name");
    }



    @Test
    public void Test3() {
        //Залогиниться (неверный пароль-ждем сообщение об ошибке)"
        openSite("https://www.training.ru/");
        findByClassAndClick("header-auth__signin");
        waitElmById("kc-content");
        findByIdAndSendKeys("username", "shprotagera@yandex.ru");
        findByIdAndSendKeys("password", "novalid");
        findByIdAndClick("kc-login");
        waitElmByCss("#kc-content-wrapper > div.uk-width-1-1\\@s > div > p");
    }







}
