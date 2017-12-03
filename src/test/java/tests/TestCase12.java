package tests;

import core.*;
import model.TestBot;
import org.junit.Test;

public class TestCase12 extends TestBase {

    TestBot botFrom = new TestBot("technopolisBot13", "technopolis16", "572241060457");
    TestBot botTo   = new TestBot("technopolisBot19", "technopolis16", "572241061743");

    @Test
    public void testWrightOrderMsgsSendingReceiving() {
        new OKMainPage(driver).doLogin(botFrom);
        new UserMainPage(driver).goToDestinationUser(botTo.getId());
        new DestinationUserPage(driver, botTo).clickWriteMsg();
        //new DialogsPage(driver);

    }

}
