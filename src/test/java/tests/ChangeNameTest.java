package tests;

import core.*;
import core.Pages.LoginMainPage;
import core.Pages.UserMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Никита on 28.12.2017.
 */
public class ChangeNameTest extends TestBase {
    @Test
    public void changeName() throws IOException {
        TestBot testBot = new TestBot("configs/auth");
        String newUserName = Integer.toString((int)(Math.random()*1234567));
        UserMainPage userMainPage = new LoginMainPage(driver).doLogin(testBot);
        userMainPage.openUCARD()
                .openSettings()
                .openPersonalData()
                .typeNewName(newUserName)
                .clickSaveButton()
                .closeSettings();
        driver.get("http://www.ok.ru");
        Assert.assertEquals(newUserName,userMainPage.getUserName());
    }
}
