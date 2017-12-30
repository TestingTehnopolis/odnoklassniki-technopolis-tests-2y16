package tests;

import core.Pages.LoginMainPage;
import core.TestBase;
import core.Pages.UserMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Никита on 28.12.2017.
 */
public class CreateNoteTest extends TestBase {
    @Test
    public void createNote() throws IOException {
        TestBot testBot = new TestBot("configs/auth");
        String text = Integer.toString((int) (Math.random() * 1234567));
        UserMainPage userMainPage =
                new LoginMainPage(driver)
                        .doLogin(testBot)
                        .openFullNoteForm()
                        .typeText(text)
                        .createNote();
        driver.get(driver.getCurrentUrl());
        Assert.assertEquals(text, userMainPage.returnCreatedNoteText());
    }
}
