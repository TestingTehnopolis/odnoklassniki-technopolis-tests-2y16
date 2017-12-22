package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import utility.TestUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс предназначен для тестирования доставки сообщений в нужном порядке.
 * TestCase #12 в моем документе в папке https://drive.google.com/drive/folders/0B9vP3_6a1ROLeW9xYmFwVEVhYjQ
 */
public class TestCase12 extends TestBase {

    private TestBot botFrom = new TestBot("technopolisBot13", "technopolis16", "572241060457");
    private TestBot botTo   = new TestBot("technopolisBot19", "technopolis16", "572241061743");
    static private List<String> msgs = new ArrayList<String>();
    static final private int NUM_MSGS = 3;
    static final private int MSG_LENGTH = 10;

    static {
        for (int i = 0; i < NUM_MSGS; i++) {
            msgs.add(TestUtilities.generateMsg((byte) MSG_LENGTH).toString());
        }
    }

    @Test
    public void testWrightOrderMsgsSendingReceiving() {

        /* отправляем сообщения...................................................................................... */
        new OKMainPage(driver)
                .doLogin(botFrom);

        UserMainPage userMainPage = new UserMainPage(driver)
                .goToDestinationUser(botTo.getId());

        new DestinationUserPage(driver, botTo)
                .clickWriteMsg();

        DialogsPage dialogsPage = new DialogsPage(driver, botTo, true)
                .typeAndSendMsgs(msgs)
                .checkCreatingMsg(msgs.get(NUM_MSGS - 1)) //ждем чтобы последнее сообщение успело прогрузиться
                .wrapMsgs();

        boolean sentFlag = true;
        for (int i = 0; i < NUM_MSGS; i++) {
            if(!dialogsPage.popLastMsg().equals(msgs.get(NUM_MSGS - i - 1))) {
                sentFlag = false;
                break;
            }
        }
        Assert.assertTrue("Напечатанные сообщения не совпадают с отобразившимися в диалоге", sentFlag);

        userMainPage.
                openExitLayer();
        Assert.assertTrue("Не дождались появления лейера для выхода",
                userMainPage.isExitLayerVisible());

        userMainPage
                .clickBtnExit();
        Assert.assertTrue("Не дождались появления лейера для подтверждения выхода",
                userMainPage.isConfirmExitLayerVisible());

        userMainPage.clickBtnConfirmExit();


        /* смотрим что сообщения дошли в нужном порядке...............................................................*/
        new OKMainPage(driver)
                .doLogin(botTo);

        UserMainPage userMainPage2 = new UserMainPage(driver)
                .goToDialogs();

        DialogsPage dialogsPage2 = new DialogsPage(driver, botFrom, false)
                .selectDialog(botFrom)
                .wrapMsgs();
        boolean receivedFlag = true;
        for (int i = 0; i < NUM_MSGS; i++) {
            if(!dialogsPage2.popLastMsg().equals(msgs.get(NUM_MSGS - i - 1))) {
                receivedFlag = false;
                break;
            }
        }
        Assert.assertTrue("переданные и принятые сообщения не совпадают", receivedFlag);

        userMainPage2.openExitLayer();
        Assert.assertTrue("Не дождались появления лейера с подтверждением выхода",
                userMainPage2.isExitLayerVisible());

        userMainPage2
                .clickBtnExit();
        Assert.assertTrue("Не дождались появления лейера для подтверждения выхода",
                userMainPage2.isConfirmExitLayerVisible());

        userMainPage
                .clickBtnConfirmExit();
        //для проверки корректности выхода из аккаунта
        new OKMainPage(driver);
    }
}
