package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import utility.TestUtilities;

/**
 * Класс предназначен для тестирования доставки сообщения между двумя пользователями.
 * TestCase #11 в моем документе в папке https://drive.google.com/drive/folders/0B9vP3_6a1ROLeW9xYmFwVEVhYjQ
 */
public class TestCase11 extends TestBase {

    private TestBot botFrom = new TestBot("technopolisBot13", "technopolis16", "572241060457");;
    private TestBot botTo = new TestBot("technopolisBot19", "technopolis16", "572241061743");;
    static private String msg = TestUtilities.generateMsg((byte) 5).toString();

    @Test
    public void testSuccessfulMsgSending() {
        new OKMainPage(driver)
                .doLogin(botFrom);
        new UserMainPage(driver)
                .goToDestinationUser(botTo.getId());
        new DestinationUserPage(driver, botTo)
                .clickWriteMsg();
        DialogsPage dialogPage = new DialogsPage(driver, botTo, true)
                .typeMsg(msg)
                .sendMsg();
        Assert.assertTrue("Не дождались появления отправленного сообщения в обасти для сообщений", dialogPage.isMsgCreated(msg));
        dialogPage.clickBtnExit();
        Assert.assertTrue("Не дождались появления лейера с подтверждением выхода", dialogPage.isExitLayerVisible());
        dialogPage.clickBtnConfirmExit();
        //todo вынести выход в отдельный класс, возвращ-ые знач-я
    }

    @Test
    public void testSuccessfulMsgReceiving() {
        //todo в отдельный класс и before для первого тестового метода
        new OKMainPage(driver).doLogin(botTo);
        new UserMainPage(driver)
                .goToDialogs();
        DialogsPage dialogPage = new DialogsPage(driver, botFrom, false)
                .selectDialog(botFrom);
        Assert.assertTrue("Не дождались появления приниятого сообщения в обасти для сообщений", dialogPage.isMsgCreated(msg));
        dialogPage.clickBtnExit();
                Assert.assertTrue("", dialogPage.isExitLayerVisible());
        dialogPage.clickBtnConfirmExit();
    }
}
