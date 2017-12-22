package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import utility.TestUtilities;

/**
 * Класс предназначен для тестирования доставки сообщения между двумя пользователями.
 * TestCase #11 в моем документе в папке https://drive.google.com/drive/folders/0B9vP3_6a1ROLeW9xYmFwVEVhYjQ
 */
public class TestCase11 extends TestBase {

    private TestBot botFrom = new TestBot("technopolisBot13", "technopolis16", "572241060457");;
    private TestBot botTo = new TestBot("technopolisBot19", "technopolis16", "572241061743");;
    static private String msg = TestUtilities.generateMsg((byte) 5).toString();

    @BeforeMethod
    @Test
    public void testSuccessfulMsgSending() {
        new OKMainPage(driver)
                .doLogin(botFrom);

        UserMainPage userMainPage = new UserMainPage(driver)
                .goToDestinationUser(botTo.getId());

        new DestinationUserPage(driver, botTo)
                .clickWriteMsg();

        DialogsPage dialogPage = new DialogsPage(driver, botTo, true)
                .typeMsg(msg)
                .sendMsg();
        Assert.assertTrue("Не дождались появления отправленного сообщения в обасти для сообщений",
                dialogPage.isMsgCreated(msg));

        userMainPage.openExitLayer();
        Assert.assertTrue("Не дождались появления лейера для выхода",
                userMainPage.isExitLayerVisible());

        userMainPage.clickBtnExit();
        Assert.assertTrue("Не дождались появления лейера для подтверждения выхода",
                userMainPage.isConfirmExitLayerVisible());

        userMainPage.clickBtnConfirmExit();
        //для проверки корректности выхода из аккаунта
        new OKMainPage(driver);
    }

    @Test
    public void testSuccessfulMsgReceiving() {
        new OKMainPage(driver)
                .doLogin(botTo);

        UserMainPage userMainPage = new UserMainPage(driver)
                .goToDialogs();

        DialogsPage dialogPage = new DialogsPage(driver, botFrom, false)
                .selectDialog(botFrom);
        Assert.assertTrue("Не дождались появления приниятого сообщения в обасти для сообщений",
                dialogPage.isMsgCreated(msg));

        userMainPage.openExitLayer();
        Assert.assertTrue("Не дождались появления лейера для выхода",
                userMainPage.isExitLayerVisible());

        userMainPage.clickBtnExit();
        Assert.assertTrue("Не дождались появления лейера для подтверждения выхода",
                userMainPage.isConfirmExitLayerVisible());

        userMainPage.clickBtnConfirmExit();
        //для проверки корректности выхода из аккаунта
        new OKMainPage(driver);
    }
}
