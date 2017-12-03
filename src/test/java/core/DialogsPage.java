package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private static final By BTN_EXIT = By.xpath(".//a[contains(text(), 'Выход')]");
    private static final By LAYER_EXIT = By.xpath(".//div[contains(@class, 'modal-new_cnt')]//div[contains(text(), 'Выход с сайта')]");
    private static final By BTN_CONFIRM_EXIT = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");


    public DialogsPage(WebDriver driver, TestBot botInterractWith, boolean fromOtherUserPage) {
        super(driver);
        HREF_DIALOG = By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '" +
                botInterractWith.getId() +
                "')]");
        if(fromOtherUserPage)
            customCheck();
    }

    public DialogsPage typeMsg(String msg) {
        Assert.assertTrue("Не дождались появления поля для ввода сообщения",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(AREA_MSG_INPUT), 10, 500));
        type(msg, AREA_MSG_INPUT);
        return this;
    }

    public DialogsPage sendMsg() {
        Assert.assertTrue("Не дождались появления кнопки для отправки сообщения",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_SEND_MSG), 10, 500));
        click(BTN_SEND_MSG);
        return this;
    }

    public DialogsPage checkCreatingMsg(String msg) {
        By MSG = By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']");
        Assert.assertTrue("Не дождались появления отправленного сообщения в обасти для сообщений",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(MSG), 10, 500));
        return this;
    }

    public DialogsPage clickBtnExit() {
        Assert.assertTrue("Не дождались появления кнопки выхода из аккаунта",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_EXIT), 10, 500));
        click(BTN_EXIT);
        return this;
    }

    public DialogsPage ckeckAppearanceLayerExit() {
        Assert.assertTrue("Не дождались появления лейера с подтверждением выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_EXIT), 10, 500));
        return this;
    }

    public DialogsPage clickBtnConfirmExit() {
        Assert.assertTrue("Не дождались появления кнопки для подтверждения выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_CONFIRM_EXIT), 10, 500));
        click(BTN_CONFIRM_EXIT);
        return this;
    }

    public DialogsPage selectDialog(TestBot bot) {
        By dialog = By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '/messages/" + bot.getId() + "')]");
        click(dialog);
        return this;
    }

    public DialogsPage checkReceiveMsg(String msg) {
        By MSG = By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']");
        Assert.assertTrue("Не дождались появления приниятого сообщения в обасти для сообщений",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(MSG), 10, 500));
        return this;
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления лейера с диалогами",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_DIALOG_LIST), 10, 500));
    }

    private void customCheck() {
        Assert.assertTrue("Не дождались появления адресата в списке диалогов",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(HREF_DIALOG), 10, 500));
        Assert.assertTrue("Не дождались активации диалога",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_DIALOG_TITLE), 10, 500));
    }
}