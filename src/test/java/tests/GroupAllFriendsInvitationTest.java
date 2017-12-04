package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;


public class GroupAllFriendsInvitationTest extends TestBase {

    /*
     Приглашение всех друзей в группу.
     Для успешного прохождения теста требуется, чтобы у используемого пользователя был хотя бы 1 друг.
     */
    @Test
    public void testAllFriendsInvitation() throws Exception {
        final String login = "technopolisBot3";
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
        groupMainPage.clickSubmitCreateButton();

        Thread.sleep(1000);

        GroupSpecificPage groupSpecificPage = new GroupSpecificPage(driver);

        // нажимаем приглашение друзей
        groupSpecificPage.clickInviteFriends();

        Thread.sleep(1000);

        // нажимаем выбрать всех
        groupSpecificPage.selectAllForInvitation();

        Thread.sleep(1000);

        // подвтерждаем приглашение друзей (нажимаем пригласить на леере)
        groupSpecificPage.submitFriendInvitation();

        Thread.sleep(3000);

        // нажимаем приглашение друзей
        groupSpecificPage.clickInviteFriends();

        // проверяем, что доступных для приглашения друзей не осталось
        Assert.assertFalse("После приглашения всех друзей имеются друзья, доступные для приглашения", groupSpecificPage.isSelectableFriendPresent());

    }
}