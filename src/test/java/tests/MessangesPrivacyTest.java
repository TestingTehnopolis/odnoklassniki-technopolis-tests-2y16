package tests;

import core.pages.MessageMainPage;
import core.pages.SessionMainPage;
import helper.ResourceLoader;
import model.TestBot;
import org.junit.Test;
import org.testng.Assert;

public class MessangesPrivacyTest extends TestBase {


    @Test
    public void messangesPrivacyTest() throws InterruptedException {
        TestBot testBot1 = ResourceLoader.getTestBot("myPage"),
                testBot2 = ResourceLoader.getTestBot("testBot1");

        new SessionMainPage(driver).doLogin(testBot1)
                .clickOnMySettings()
                .clickOnPrivacy()
                .clickOnMessagesOnlyFriendsAndSave();

        reopenDriver();

        MessageMainPage messageMainPage = new SessionMainPage(driver).doLogin(testBot2)
                .search(testBot1.getProfileId())
                .clickPeopleTab()
                .clickSearchById()
                .openUserPage(testBot1.getFullName())
                .clickWriteMessage();

        Assert.assertTrue(messageMainPage.isMessagesNotAllowed(), "Messages are allowed");
    }


}
