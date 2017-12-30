package tests;

import core.Pages.LoginMainPage;
import core.Pages.UserMainPage;
import core.TestBase;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Никита on 28.12.2017.
 */
public class CreateAvatarComment extends TestBase {
    @Test
    public void createComment() throws InterruptedException, IOException {
        TestBot testBot1 = new TestBot("configs/auth");
        TestBot testBot2 = new TestBot("configs/auth1");
        String authorComment = Integer.toString((int) (Math.random() * 1234567));

        UserMainPage userMainPage = new LoginMainPage(driver).doLogin(testBot2);
        String userLink = userMainPage.getUserLink();
        userMainPage = userMainPage
                .openUCARD()
                .clickLogout()
                .confirmLogout()
                .doLogin(testBot1);

        String authorName = userMainPage.getUserName();
        driver.get(userLink);
        userMainPage
                .clickOnAvatar()
                .typeComment(authorComment)
                .submitComment();
        driver.get("http://www.ok.ru");

        userMainPage = userMainPage
                .openUCARD()
                .clickLogout()
                .confirmLogout()
                .doLogin(testBot2);
        Assert.assertTrue("Нет комментария", userMainPage.clickOnAvatar().isCommentPresent(authorComment, authorName));
    }
}
