package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import utility.TestUtilities;

import java.util.ArrayList;
import java.util.List;

public class TestCase12 extends TestBase {

    private TestBot botFrom = new TestBot("technopolisBot13", "technopolis16", "572241060457");
    private TestBot botTo   = new TestBot("technopolisBot19", "technopolis16", "572241061743");
    static private List<String> msgs = new ArrayList<String>();

    static {
        for (int i = 0; i < 3; i++) {
            msgs.add(TestUtilities.generateMsg((byte) 5).toString());
        }
    }

    @Test
    public void testWrightOrderMsgsSendingReceiving() {
        //отправляем сообщения
        new OKMainPage(driver).doLogin(botFrom);
        new UserMainPage(driver).goToDestinationUser(botTo.getId());
        new DestinationUserPage(driver, botTo).clickWriteMsg();
        DialogsPage dialogsPage = new DialogsPage(driver, botTo, true)
                .typeAndSendMsgs(msgs);
        Assert.assertTrue("переданные и принятые сообщения не совпадают", true);
        dialogsPage.clickBtnExit();
        Assert.assertTrue("Не дождались появления лейера с подтверждением выхода", dialogsPage.isExitLayerVisible());
        dialogsPage.clickBtnConfirmExit();

        //смотрим что сообщения дошли в нужном порядке
        new OKMainPage(driver).doLogin(botTo);
        new UserMainPage(driver).goToDialogs();
        DialogsPage dialogsPage2 = new DialogsPage(driver, botFrom, false)
                .selectDialog(botFrom);
        Assert.assertTrue("переданные и принятые сообщения не совпадают", dialogsPage.isMsgsReceived(msgs));
        dialogsPage2
                .clickBtnExit()
                .ckeckAppearanceLayerExit()
                .clickBtnConfirmExit();
    }
}
