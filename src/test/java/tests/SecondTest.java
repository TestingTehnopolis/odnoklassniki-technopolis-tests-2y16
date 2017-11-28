package tests;

import core.Constants;
import core.GroupHelper;
import core.SessionHelper;
import core.UserMainPageHelper;
import model.TestBot;
import org.junit.Test;

public class SecondTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        SessionHelper sessionHelper = new SessionHelper(driver);

        sessionHelper.doLogin(new TestBot("technopolisBot18", "technopolis16"));


        UserMainPageHelper mainPageHelper = new UserMainPageHelper(driver);

        mainPageHelper.clickGroupsOnToolbar();

        GroupHelper groupHelper = new GroupHelper(driver);
        groupHelper.clickCreateGroup();
        groupHelper.clickGroupByType(Constants.GroupType.GROUP_BY_INTERESTS);
        groupHelper.typeGroupName("Group4");
        groupHelper.clickCreateButton();
    }
}