package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс предоставляет методы для действия на странице другого пользователя.
 */
public class DestinationUserPage extends PageBase {

    //базовые элементы страницы
    private static final By BTN_MAKE_GIFT = By.xpath(".//a[@id='action_menu_send_gift_a']");
    private static By USER_PAGE_TITLE;

    private static final By BTN_WRITE_MSG = By.id("action_menu_write_message_button_a");
    private static final By LAYER_DIALOG_LIST = By.id("msg_dialogs_list_scroller");
    private static By HREF_DIALOG;
    private static final By LBL_DIALOG_TITLE = By.xpath(".//span[contains(@class, 'curPointer js-open-menu js-opponent-name')]");
    private static final By AREA_MSG_INPUT = By.xpath(".//div[contains(@id, 'field_txt')]");
    private static final By BTN_SEND_MSG = By.xpath(".//button[contains(@title, 'Отправить')]");
    private static final By BTN_EXIT = By.xpath(".//a[contains(text(), 'Выход')]");
    private static final By LAYER_EXIT = By.xpath(".//div[contains(@class, 'modal-new_cnt')]//div[contains(text(), 'Выход с сайта')]");
    private static final By BTN_CONFIRM_EXIT = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");


    public DestinationUserPage(WebDriver driver, TestBot destinationUser) {
        super(driver);
        USER_PAGE_TITLE = By.xpath(".//h1[contains(@class,'mctc_name_tx bl') and contains(text(), '" +
                destinationUser.getLogin().toLowerCase() +
                "')]");
        HREF_DIALOG = By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '" +
                destinationUser.getId() +
                "')]");
        customCheck();
    }

    public DestinationUserPage clickWriteMsg() {
        Assert.assertTrue("Не дождались появления кнопки \"написать сообщение\"",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_WRITE_MSG), 10, 500));
        click(BTN_WRITE_MSG);
        return this;
    }

    public DestinationUserPage checkAppearanceMsgsLayer() {
        Assert.assertTrue("Не дождались появления лейера с диалогами",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_DIALOG_LIST), 10, 500));
        return this;
    }

    public DestinationUserPage checkDialogInListAndActivate() {
        Assert.assertTrue("Не дождались появления адресата в списке диалогов",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(HREF_DIALOG), 10, 500));
        Assert.assertTrue("Не дождались активации диалога",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_DIALOG_TITLE), 10, 500));
        return this;
    }

    public DestinationUserPage typeMsg(String msg) {
        Assert.assertTrue("Не дождались появления поля для ввода сообщения",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(AREA_MSG_INPUT), 10, 500));
        type(msg, AREA_MSG_INPUT);
        return this;
    }

    public DestinationUserPage sendMsg() {
        Assert.assertTrue("Не дождались появления кнопки для отправки сообщения",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_SEND_MSG), 10, 500));
        click(BTN_SEND_MSG);
        return this;
    }

    public DestinationUserPage checkCreatingMsg(String msg) {
        By MSG = By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']");
        Assert.assertTrue("Не дождались появления отправленного сообщения в обасти для сообщений",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(MSG), 10, 500));
        return this;
    }

    public DestinationUserPage clickBtnExit() {
        Assert.assertTrue("Не дождались появления кнопки выхода из аккаунта",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_EXIT), 10, 500));
        click(BTN_EXIT);
        return this;
    }

    public DestinationUserPage ckeckAppearanceLayerExit() {
        Assert.assertTrue("Не дождались появления лейера с подтверждением выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_EXIT), 10, 500));
        return this;
    }


    public DestinationUserPage clickBtnConfirmExit() {
        Assert.assertTrue("Не дождались появления кнопки для подтверждения выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_CONFIRM_EXIT), 10, 500));
        click(BTN_CONFIRM_EXIT);
        return this;
    }

    @Override
    protected void check() {
        /**
         * {@link DestinationUserPage#customCheck()}
         */
    }

    private void customCheck() {
        Assert.assertTrue("Не дождались появления ссылки \"Подарить подарок\"",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_MAKE_GIFT), 10, 500));
        //проверим что мы на страице нужного пользователя
        Assert.assertTrue("Не дождались появления нужного заголовка профиля",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(USER_PAGE_TITLE), 10, 500));
    }
}
