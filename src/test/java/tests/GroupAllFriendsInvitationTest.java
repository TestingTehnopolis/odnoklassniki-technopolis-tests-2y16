package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;


public class GroupAllFriendsInvitationTest extends TestBase {

    @Test
    public void testAllFriendsInvitation() throws Exception {
        final String login = "technopolisBot14";
        final String password = "technopolis16";
        final String groupName = "Please join me";

        // логин
        new LoginMainPage(driver).doLogin(new TestBot(login, password));

        Thread.sleep(1000);

        // создадим новую группу, в которую будем добавлять всех друзей
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickGroupsOnToolbar();

        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName(groupName);
        groupMainPage.clickCreateButton();

        Thread.sleep(1000);

        GroupSpecificPage groupSpecificPage = new GroupSpecificPage(driver);

        // нажимаем приглашение друзей
        groupSpecificPage.clickInviteFriends();

        // нажимаем выбрать всех
        groupSpecificPage.selectAllForInvitation();

        // подвтерждаем приглашение друзей (нажимаем пригласить на леере)
        groupSpecificPage.submitFriendInvitation();

        Thread.sleep(3000);

        // нажимаем приглашение друзей
        groupSpecificPage.clickInviteFriends();

        // проверяем, есть закладка для созданной группы на странице
        Assert.assertFalse("После приглашения всех друзей имеются друзья, доступные для приглашения", groupSpecificPage.isSelectableFriendPresent());

    }
}