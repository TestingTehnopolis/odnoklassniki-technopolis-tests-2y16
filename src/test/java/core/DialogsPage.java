package core;

import com.sun.jna.platform.win32.WinUser;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.MsgWrapper;
import utility.Transformer;

import java.util.List;

/**
 * Класс отвечает за действия на странице с переписками.
 */
public class DialogsPage extends PageBase {

    //базовые элементы страницы
    private static final By LAYER_DIALOG_LIST = By.id("msg_dialogs_list_scroller");
    private static By HREF_DIALOG;
    private static final By LBL_DIALOG_TITLE = By.xpath(".//span[contains(@class, 'curPointer js-open-menu js-opponent-name')]");

    private static final By AREA_MSG_INPUT = By.xpath(".//div[contains(@id, 'field_txt')]");
    private static final By BTN_SEND_MSG = By.xpath(".//button[contains(@title, 'Отправить')]");
    private Transformer tf;
    private List<MsgWrapper> list;


    public DialogsPage(WebDriver driver, TestBot botInteractWith, boolean fromOtherUserPage) {
        super(driver);

        HREF_DIALOG = By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '" +
                botInteractWith.getId() +
                "')]");

        Assert.assertTrue("Адресат не появился в списке диалогов",
                isElementVisible(HREF_DIALOG));

        if(fromOtherUserPage)
            customCheck();
    }

    public DialogsPage typeMsg(String msg) {
        Assert.assertTrue("Не появмлось поле для ввода сообщения",
                isElementVisible(AREA_MSG_INPUT));
        type(msg, AREA_MSG_INPUT);

        return this;
    }

    public DialogsPage sendMsg() {
        Assert.assertTrue("Не появилась кнопка для отправки сообщения",
                isElementVisible(BTN_SEND_MSG));
        click(BTN_SEND_MSG);

        return this;
    }

    public DialogsPage checkCreatingMsg(String msg) {
        By MSG = By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']");
        Assert.assertTrue("Не дождались появления отправленного сообщения в обасти для сообщений",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(MSG), 10, 500));
        return this;
    }

    public boolean isMsgCreated(String msg) {
        return explicitWait(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']")), 10, 500);
    }

    public DialogsPage wrapMsgs() {
        tf = new Transformer(driver);
        list = tf.getMsgs();
        return this;
    }

    public String popLastMsg() {
        return list.remove(list.size() - 1).getMsgText();
    }

    public DialogsPage selectDialog(TestBot bot) {
        Assert.assertTrue("Не появился диалог с отправителем",
                isElementVisible(By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '/messages/" + bot.getId() + "')]")));
        By dialog = By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '/messages/" + bot.getId() + "')]");
        click(dialog);

        return this;
    }

    public DialogsPage typeAndSendMsgs(List<String> msgs) {
        for (int i = 0; i < msgs.size(); i++) {
            typeMsg(msgs.get(i));
            sendMsg();
        }
        return this;
    }

    public boolean isMsgVisible(String msg) {
        By MSG = By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']");
        return isElementVisible(MSG);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления лейера с диалогами",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_DIALOG_LIST), 10, 500));
    }

    private void customCheck() {
        Assert.assertTrue("Не дождались активации диалога",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_DIALOG_TITLE), 10, 500));
    }


}
