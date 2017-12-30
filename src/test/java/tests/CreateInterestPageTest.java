package tests;

import core.Pages.LoginMainPage;
import core.TestBase;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Никита on 28.12.2017.
 */
public class CreateInterestPageTest extends TestBase {

    @Test
    public void createPublicPage() throws IOException {
        TestBot testBot = new TestBot("configs/auth");
        String groupName = Integer.toString((int) (Math.random() * 1234567));
        String groupNameActual =
                new LoginMainPage(driver)
                        .doLogin(testBot)
                        .clickGroupsOnToolbar()
                        .clickCreateGroup()
                        .clickInterestGroup()
                        .typeGroupName(groupName)
                        .clickCreateButton()
                        .getGroupName();
        Assert.assertEquals(groupName, groupNameActual);
    }

}
