package tests;

import core.*;
import model.TestBot;
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
        new DialogsPage(driver, botTo, true)
                .typeMsg(msg)
                .sendMsg()
                .checkCreatingMsg(msg)
                .clickBtnExit()
                .ckeckAppearanceLayerExit()
                .clickBtnConfirmExit();
    }

    @Test
    public void testSuccessfulMsgReceiving() {
        new OKMainPage(driver).doLogin(botTo);
        new UserMainPage(driver)
                .goToDialogs();
        new DialogsPage(driver, botFrom, false)
                .selectDialog(botFrom)
                .checkReceiveMsg(msg)
                .clickBtnExit()
                .ckeckAppearanceLayerExit()
                .clickBtnConfirmExit();
    }
}
