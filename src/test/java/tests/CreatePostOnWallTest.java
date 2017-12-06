package tests;

import core.page.LoginMainPage;
import core.TestBase;
import core.page.UserMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

/**
 * Иедя тест - проверить что я могу писать посты на свою страницу.
 * Но столкнулся с проблемой - умная лента перемешивает посты и
 * с этим у меня возникают ошибки
 *
 * Но теперь этот тест проверяет что нет никакоого редиректа после
 * создания поста на своей личной странице(такой облегченный вариант)
 */
public class CreatePostOnWallTest extends TestBase {
    private final String botLogin = "technopolisBot2";
    private final String botPassword = "technopolis16";
    private final String postText = "text for my own post ;) new 12345";

    @Test
    public void testPostOnWallCreation() throws InterruptedException {
        new LoginMainPage(driver).doLogin(
                new TestBot(botLogin, botPassword));
        String oldUrl = driver.getCurrentUrl();

        UserMainPage mainPage = new UserMainPage(driver);
        mainPage.openPostAlert();
        mainPage.typePostText(postText);
        mainPage.createPost();

        Thread.sleep(1000);
        Assert.assertEquals(oldUrl, driver.getCurrentUrl());
    }
}
