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
        final String bookmarkScrollBlockID = "hook_Block_LeftColumnBookmarks";

        // логин
        new LoginMainPage(driver).doLogin(new TestBot(login, password));

        // создадим новую группу, которую будем добавлять в закладки
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickGroupsOnToolbar();

        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName(groupName);
        groupMainPage.clickSubmitCreateButton();

        GroupSpecificPage groupSpecificPage = new GroupSpecificPage(driver);

        // добавляем закладку
        groupSpecificPage.clickAddBookmark();

        // переходим на домашнюю страницу
        userMainPage.clickHome();

        Thread.sleep(1000);

        // производим скролл до блока с закладками
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById(\"" + bookmarkScrollBlockID + "\").scrollIntoView();", "");

        // проверяем, есть закладка для созданной группы на странице
        Assert.assertTrue("Закладка с группой не найдена", userMainPage.isBookmarkPresent(groupName));

    }
}