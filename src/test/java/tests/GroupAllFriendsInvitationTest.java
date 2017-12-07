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

        // логин, затем создадим новую группу, в которую будем добавлять всех друзей
        UserMainPage userMainPage = new LoginMainPage(driver).doLogin(new TestBot(login, password));

        userMainPage.clickGroupsOnToolbar();

        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName(groupName);
        GroupSpecificPage groupSpecificPage = groupMainPage.clickSubmitCreateButton();

        // нажимаем приглашение друзей
        groupSpecificPage.clickInviteFriends();

        // нажимаем выбрать всех
        groupSpecificPage.selectAllForInvitation();

        // подвтерждаем приглашение друзей (нажимаем пригласить на леере)
        groupSpecificPage = groupSpecificPage.submitFriendInvitation();

        // ждем пока пропадет модальное окно с сообщением о том, что друзья приглашены
        Thread.sleep(2000);
        // нажимаем приглашение друзей
        groupSpecificPage.clickInviteFriends();

        // проверяем, что доступных для приглашения друзей не осталось
        Assert.assertFalse("После приглашения всех друзей имеются друзья, доступные для приглашения", groupSpecificPage.isSelectableFriendPresent());

    }
}