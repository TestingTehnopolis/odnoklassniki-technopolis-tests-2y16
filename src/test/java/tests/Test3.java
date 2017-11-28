package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;


/*
 * Третий кейс: описание в README.md: "4. Создание группы с типом "Компания или организация" с огр. 18+ ""
 */
public class Test3 extends TestBase {
    private SessionHelper sessionHelper;
    private UserMainPageHelper userMainPageHelper;
    private GroupHelper groupHelper;
    private URLHelper urlHelper;

    private String login;
    private String password;

    private String login2;
    private String password2;

    private String publicPageName;
    private String publicPageDescription;
    private String subCategory;
    private String groupUrl;
    private String profile2;


    @Before
    public void before() throws Exception {
        sessionHelper = new SessionHelper(driver);
        userMainPageHelper = new UserMainPageHelper(driver);
        groupHelper = new GroupHelper(driver);
        urlHelper = new URLHelper(driver);


        login = "technopolisBot18";
        password = "technopolis16";

        // я сменил ей возраст на 16 лет
        login2 = "technopolisBot15";
        password2 = "technopolis16";

        publicPageName = "Группа компании 01";
        publicPageDescription = "Описание компании 01";
        subCategory = Constants.GroupTypeRus.COMPANY_OR_ORGANIZATION;

        profile2 = "https://ok.ru/profile/572241059435";
    }

    @After
    public void after() throws Exception {
        // logout from the second profile
        urlHelper.goToUrl(new URL(profile2));
        sessionHelper.clickAccountAndLogout();

        // delete the early created group
        sessionHelper.doLogin(new TestBot(login, password));
        urlHelper.goToUrl(new URL(groupUrl));
        groupHelper.clickDeleteGroup();
    }

    @Test
    public void createPublicPage() throws Exception {
        // creating group
        sessionHelper.doLogin(new TestBot(login, password));
        userMainPageHelper.clickGroupsOnToolbar();
        groupHelper.clickCreateGroup();
        groupHelper.clickGroupByType(Constants.GroupType.COMPANY_OR_ORGANIZATION);
        groupHelper.typeGroupName(publicPageName);
        groupHelper.typeDescription(publicPageDescription);
        groupHelper.clickSubCategory(Constants.MixedCategory.COMPANY_COMPUTER_IT);
        groupHelper.clickAge();
        groupHelper.clickCreateButton();

        // remember the current url of group
        Thread.sleep(2000);
        groupUrl = urlHelper.getCurrentURL();

        groupHelper.clickSettings();

        // validate
        Assert.assertEquals(publicPageName, groupHelper.getGroupName());
        Assert.assertEquals(publicPageDescription, groupHelper.getGroupDescription());
        Assert.assertEquals(subCategory.substring(0, 8),
                            groupHelper.getGroupSubcategory().substring(0, 8));
        sessionHelper.clickAccountAndLogout();

        // go to the first profile and check permission
        sessionHelper.doLogin(new TestBot(login2, password2));
        userMainPageHelper.clickGroupsOnToolbar();
        urlHelper.goToUrl(new URL(groupUrl));

        Assert.assertEquals(true, groupHelper.check18());
    }
}
