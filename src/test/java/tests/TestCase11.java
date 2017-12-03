package tests;

import core.*;
import model.TestBot;
import org.junit.Test;
import java.util.Random;

/**
 * Класс предназначен для тестирования доставки сообщения между двумя пользователями.
 * TestCase #11 в моем документе в папке https://drive.google.com/drive/folders/0B9vP3_6a1ROLeW9xYmFwVEVhYjQ
 */
public class TestCase11 extends TestBase {

    private TestBot botFrom;
    private TestBot botTo;
    static private String msg = generateMsg((byte) 5).toString();;

    public TestCase11() {
        botFrom = new TestBot("technopolisBot13", "technopolis16", "572241060457");
        botTo = new TestBot("technopolisBot19", "technopolis16", "572241061743");
    }

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

    static private StringBuffer generateMsg(byte msgLength) {
        Random random = new Random();
        String dict = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuffer res = new StringBuffer(msgLength);
        for (int i = 0; i < msgLength; i++) {
            res.append(dict.charAt(random.nextInt(dict.length()-1)));
        }
        return res;
    }
}
