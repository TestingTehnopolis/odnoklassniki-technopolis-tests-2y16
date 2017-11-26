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
 */
public class CreatePostOnWallTest extends TestBase {

    private final String postText = "text for my own post ;) new 12345";

    @Test
    public void testPostOnWallCreation() throws InterruptedException {
        new LoginMainPage(driver).doLogin(
                new TestBot("technopolisBot2", "technopolis16"));
        UserMainPage mainPage = new UserMainPage(driver);

        int startAmount = mainPage.getOccurenceOfStringInPosts(postText);
        System.out.printf(String.valueOf(startAmount));

        mainPage.openPostAlert();
        mainPage.typePostText(postText);
        mainPage.createPost();

        Thread.sleep(5000);

        int endAmount = mainPage.getOccurenceOfStringInPosts(postText);

        //TODO: спросить как этот тест лучше сделать(умная лента мешает)
        System.out.println(endAmount);
        Assert.assertEquals(1, endAmount - startAmount);
    }

}
