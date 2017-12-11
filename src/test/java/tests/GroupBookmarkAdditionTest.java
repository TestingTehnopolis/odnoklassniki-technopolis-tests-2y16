package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GroupBookmarkAdditionTest extends TestBase {

    /*
     Добавление группы в закладки.
     */
    @Test
    public void testGroupBookmarkAddition() throws Exception {
        final String login = "technopolisbot3";
        final String password = "technopolis16";

        /*
         зададим название группы которую будем добавлять в закладки,
         используем точное текущее время
         */
        final String groupName = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS").format(new Date());

        // логин, затем создадим новую группу, которую будем добавлять в закладки
        UserMainPage userMainPage = new LoginMainPage(driver).doLogin(new TestBot(login, password));
        GroupMainPage groupMainPage = userMainPage.clickGroupsOnToolbar();

        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName(groupName);
        GroupSpecificPage groupSpecificPage = groupMainPage.clickSubmitCreateButton();

        // добавляем закладку
        groupSpecificPage.clickAddBookmark();

        // переходим на домашнюю страницу
        userMainPage = groupSpecificPage.getToolbar().clickHome();

        // производим скролл до блока с закладками
        userMainPage.scrollToBookmarks();

        // проверяем, есть закладка для созданной группы на странице
        Assert.assertTrue("Закладка с группой не найдена", userMainPage.isBookmarkPresent(groupName));

    }
}