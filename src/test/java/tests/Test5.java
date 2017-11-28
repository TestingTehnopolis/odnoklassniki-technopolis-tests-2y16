package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;


/*
 * Пятый кейс: описание в README.md: "12. Приглашение друга"
 */
public class Test5 extends TestBase {
    private SessionHelper sessionHelper;
    private UserMainPageHelper userMainPageHelper;
    private GroupHelper groupHelper;
    private URLHelper urlHelper;
    private FriendHelper friendHelper;

    private String login;
    private String password;

    private String login2;
    private String password2;

    private String profile;  // bot18
    private String profile2; // bot15

    private String publicPageName;
    private String publicPageDescription;


    @Before
    public void before() throws Exception {
        sessionHelper = new SessionHelper(driver);
        userMainPageHelper = new UserMainPageHelper(driver);
        groupHelper = new GroupHelper(driver);
        urlHelper = new URLHelper(driver);
        friendHelper = new FriendHelper(driver);

        login = "technopolisBot18";
        password = "technopolis16";

        login2 = "technopolisBot15";
        password2 = "technopolis16";

        publicPageName = "Group name Test5 01";
        publicPageDescription = "Group description Test5 01";

        profile = "https://ok.ru/profile/572241061230";
        profile2 = "https://ok.ru/profile/572241059435";
    }

    @After
    public void after() throws Exception {
        urlHelper.goToUrl(new URL(profile2));
        friendHelper.deleteFriend();
    }

    @Test
    public void inviteFriendIntoTheGroup() throws Exception {

        // go to the first profile and do something
        sessionHelper.doLogin(new TestBot(login, password));
        userMainPageHelper.clickGroupsOnToolbar();

        // creating group
        groupHelper.clickCreateGroup();
        groupHelper.clickGroupByType(Constants.GroupType.PUBLIC_PAGE);
        groupHelper.typeGroupName(publicPageName);
        groupHelper.typeDescription(publicPageDescription);
        groupHelper.clickSubCategory(Constants.MixedCategory.COMPUTER_AND_INTERNET);
        groupHelper.clickCreateButton();

        // remember the current url of group
        Thread.sleep(2000);
        String groupUrl = urlHelper.getCurrentURL();

        // go to the needed profile and add it in friend
        urlHelper.goToUrl(new URL(profile2));
        friendHelper.clickAddToFriend();
        urlHelper.goToUrl(new URL(profile));
        sessionHelper.clickAccountAndLogout();

        // go to the second profile and confirm invitation
        sessionHelper.doLogin(new TestBot(login2, password2));
        friendHelper.confirmAddFriend();
        urlHelper.goToUrl(new URL(profile2));
        sessionHelper.clickAccountAndLogout();

        // go to the first profile and invite new friend to the early created group
        sessionHelper.doLogin(new TestBot(login, password));
        urlHelper.goToUrl(new URL(groupUrl));
        friendHelper.clickInviteFriends();
        friendHelper.clickInviteFriendsToGroup();
        urlHelper.goToUrl(new URL(profile));
        sessionHelper.clickAccountAndLogout();

        // go to the second profile and confirm invitation
        sessionHelper.doLogin(new TestBot(login2, password2));
        friendHelper.confirmInviteToGroup();
        sessionHelper.clickAccountAndLogout();

        // go to the first profile and check confirmation
        sessionHelper.doLogin(new TestBot(login, password));
        urlHelper.goToUrl(new URL(groupUrl));

        // 1 friend
        Assert.assertEquals(String.valueOf(1), friendHelper.validateAddedFriend());
    }
}
