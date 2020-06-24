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
        logIn();
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

    @Test
    public void Test4() {
        //разлогиниться (выйти из сиcтемы)
        logIn();
        findByClassAndClick("arrow");
        waitElmByCss("#header > div.container > div.user-navigation-container > div.header-controls > div.dropdown.user-info-desktop.open > div > div:nth-child(5) > a");
        findByCssAndClick("#header > div.container > div.user-navigation-container > div.header-controls > div.dropdown.user-info-desktop.open > div > div:nth-child(5) > a");
        waitElmByClass("header-auth__signin");
    }

    @Test
    public void Test5() {
        //поиск тренингов в г. Самаре
        openSite("https://www.training.ru/");
        waitElmByCss("#training > div.filters.ng-isolate-scope > div.filter-toggle > form > input");
        findByCssAndSendKeys("#training > div.filters.ng-isolate-scope > div.filter-toggle > form > input", "самара");
        waitElmByClass("checkmark");




    }






}
