package tests;

import core.pages.IFriendRequestsMainPage;
import core.pages.SessionMainPage;
import helper.ResourceLoader;
import model.TestBot;
import org.junit.After;
import org.junit.Test;
import org.testng.Assert;

public class AddToFriendTest extends TestBase {

    @Test
    public void sendRequestToFriend() throws InterruptedException {

        TestBot testBot1 = ResourceLoader.getTestBot("testBot1"),
                testBot2 = ResourceLoader.getTestBot("myPage");

        new SessionMainPage(driver).doLogin(testBot1)
                .search(testBot2.getProfileId())
                .clickPeopleTab()
                .clickSearchById()
                .sendRequestToFriend(testBot2.getFullName())
                .andRequestSend();

        reopenDriver();

        IFriendRequestsMainPage friendRequestsMainPage = new SessionMainPage(driver).doLogin(testBot2)
                .clickFriendsOnToolbar()
                .clickFriendRequests();

        Assert.assertTrue(friendRequestsMainPage.isRequestPresent(testBot1), "Request not present");

    }

    @After
    public void revokeRequestToFriend() throws InterruptedException {
        reopenDriver();

        TestBot testBot1 = ResourceLoader.getTestBot("testBot1"),
                testBot2 = ResourceLoader.getTestBot("myPage");


        new SessionMainPage(driver).doLogin(testBot1)
                .search(testBot2.getProfileId())
                .clickPeopleTab()
                .clickSearchById()
                .openUserPage(testBot2.getFullName())
                .revokeRequestToFriend();
    }

}


