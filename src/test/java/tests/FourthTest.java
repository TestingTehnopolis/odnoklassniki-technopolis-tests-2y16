package tests;

import core.TestBase;
import core.page.CurrentGroupMainPage;
import core.page.LoginMainPage;
import core.page.UserMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест кликает на "Создать новую тему" на личной странице и
 * ничего не вводит в текстовое поле.
 * Проверяет, что кнопку "Поделиться нельзя нажать"
 */
public class FourthTest extends TestBase {

    @Test
    public void deletePostTest() throws InterruptedException {
        new LoginMainPage(driver).doLogin(
                new TestBot("technopolisBot2", "technopolis16"));
        UserMainPage mainPage = new UserMainPage(driver);

        mainPage.openPostAlert();
        Assert.assertEquals(true, mainPage.tryClickToButton());
    }

}
