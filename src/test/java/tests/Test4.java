package tests;

import core.Constants;
import core.GroupHelper;
import core.SessionHelper;
import core.UserMainPageHelper;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/*
 * Четвертый кейс: описание в README.md: "10. Создание группы с невалидным веб-сайтом""
 */
public class Test4 extends TestBase {
    private SessionHelper sessionHelper;
    private UserMainPageHelper userMainPageHelper;
    private GroupHelper groupHelper;

    private String login;
    private String password;

    private String publicPageName;
    private String publicPageDescription;
    private String website;


    @Before
    public void before() throws Exception {
        sessionHelper = new SessionHelper(driver);
        userMainPageHelper = new UserMainPageHelper(driver);
        groupHelper = new GroupHelper(driver);

        login = "technopolisBot18";
        password = "technopolis16";

        publicPageName = "Группа валидация 01";
        publicPageDescription = "Описание валидация 01";
        website = "invalid_website";
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
        groupHelper.typeWebsite(website);
        groupHelper.clickCreateButton();

        Thread.sleep(5000);

        // validate
        Assert.assertEquals("Неправильный адрес сайта", groupHelper.checkInvalidWebsite());
    }
}
