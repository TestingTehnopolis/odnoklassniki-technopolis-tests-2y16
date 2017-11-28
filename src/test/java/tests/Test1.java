package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;


/*
 * Первый кейс: описание в README.md: "1. Создание группы с типом "Публичная страница""
 */
public class Test1 extends TestBase {
    private SessionHelper sessionHelper;
    private UserMainPageHelper userMainPageHelper;
    private GroupHelper groupHelper;
    private URLHelper urlHelper;

    private String login;
    private String password;

    private String publicPageName;
    private String publicPageDescription;
    private String subCategory;
    private String groupUrl;

    @Before
    public void before() throws Exception {
        sessionHelper = new SessionHelper(driver);
        userMainPageHelper = new UserMainPageHelper(driver);
        groupHelper = new GroupHelper(driver);
        urlHelper = new URLHelper(driver);

        login = "technopolisBot18";
        password = "technopolis16";

        publicPageName = "Group name Test1 01";
        publicPageDescription = "Group description Test1 01";
        subCategory = "Публичная страница";
    }

    @After
    public void after() throws Exception {
        urlHelper.goToUrl(new URL(groupUrl));
        groupHelper.clickDeleteGroup();
    }

    @Test
    public void createPublicPage() throws Exception {
        sessionHelper.doLogin(new TestBot(login, password));

        userMainPageHelper.clickGroupsOnToolbar();

        groupHelper.clickCreateGroup();
        groupHelper.clickGroupByType(Constants.GroupType.PUBLIC_PAGE);
        groupHelper.typeGroupName(publicPageName);
        groupHelper.typeDescription(publicPageDescription);
        groupHelper.clickSubCategory(Constants.MixedCategory.COMPUTER_AND_INTERNET);
        groupHelper.clickCreateButton();

        // remember the current url of group
        Thread.sleep(2000);
        groupUrl = urlHelper.getCurrentURL();

        groupHelper.clickSettings();

        Assert.assertEquals(publicPageName, groupHelper.getGroupName());
        Assert.assertEquals(publicPageDescription, groupHelper.getGroupDescription());
        Assert.assertEquals(subCategory, groupHelper.getGroupSubcategory().substring(0, 18));
    }
}
