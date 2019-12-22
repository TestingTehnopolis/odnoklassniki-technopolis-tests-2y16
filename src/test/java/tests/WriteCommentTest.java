package tests;

import com.mifmif.common.regex.Generex;
import core.pages.PhotoMainPage;
import core.pages.SessionMainPage;
import helper.ResourceLoader;
import model.TestBot;
import org.junit.Test;
import org.testng.Assert;

public class WriteCommentTest extends TestBase {

    @Test
    public void WriteComment() throws InterruptedException {
        TestBot testBot1 = ResourceLoader.getTestBot("testBot1"),
                testBot2 = ResourceLoader.getTestBot("myPage");

        String comment = new Generex("comment [0-9]{10,20}").random();

        new SessionMainPage(driver).doLogin(testBot1)
                .search(testBot2.getProfileId())
                .clickPeopleTab()
                .clickSearchById()
                .openUserPage(testBot2.getFullName())
                .clickOnAvatar()
                .typeComment(comment)
                .submitComment();

        reopenDriver();

        PhotoMainPage photoMainPage = new SessionMainPage(driver).doLogin(testBot2)
                .clickOnAvatar();

        Assert.assertTrue(photoMainPage.isCommentPresent(comment, testBot1), "Request not present");

    }

}
