package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс предоставляет методы для совершения действий на главной странице пользователя.
 */
public class UserMainPage extends PageBase {

    //базовые элементы страницы
    private static final By PERSONAL_BLOCK = By.xpath(".//div[@id='hook_Block_LeftColumnTopCard']");
    private static final By LBL_THOUGHTS = By.xpath(".//div[contains(@class, 'input_placeholder') and contains(text(), 'О чём вы думаете?')]");

    private static final By ICON_MSG = By.id("msg_toolbar_button");
    private static final By LAYER_DIALOG_LIST = By.id("msg_dialogs_list_scroller");
    private static final By BTN_EXIT = By.xpath(".//a[contains(text(), 'Выход')]");
    private static final By LAYER_EXIT = By.xpath(".//div[contains(@class, 'modal-new_cnt')]//div[contains(text(), 'Выход с сайта')]");
    private static final By BTN_CONFIRM_EXIT = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public UserMainPage goToDestinationUser(String id) {
        driver.get("https://ok.ru/profile/" + id + "/");
        return this;
    }

    public UserMainPage goToDialogs() {
        Assert.assertTrue("Не дождались появления иконки \"Сообщения\"",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(ICON_MSG), 10, 500));
        click(ICON_MSG);
        return this;
    }

    public UserMainPage checkAppearanceMsgsLayer() {
        Assert.assertTrue("Не дождались появления лейера с диалогами",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_DIALOG_LIST), 10, 500));
        return this;
    }

    public UserMainPage selectDialog(TestBot bot) {
        By dialog = By.xpath(".//a[contains(@class, 'chats_i_ovr') and contains(@href, '/messages/" + bot.getId() + "')]");
        click(dialog);
        return this;
    }

    public UserMainPage checkReceiveMsg(String msg) {
        By MSG = By.xpath(".//div[contains(@class, 'msg_tx')]//span[text()='" + msg + "']");
        Assert.assertTrue("Не дождались появления приниятого сообщения в обасти для сообщений",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(MSG), 10, 500));
        return this;
    }

    public UserMainPage clickBtnExit() {
        Assert.assertTrue("Не дождались появления кнопки выхода из аккаунта",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_EXIT), 10, 500));
        click(BTN_EXIT);
        return this;
    }

    public UserMainPage ckeckAppearanceLayerExit() {
        Assert.assertTrue("Не дождались появления лейера с подтверждением выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_EXIT), 10, 500));
        return this;
    }

    public UserMainPage clickBtnConfirmExit() {
        Assert.assertTrue("Не дождались появления кнопки для подтверждения выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_CONFIRM_EXIT), 10, 500));
        click(BTN_CONFIRM_EXIT);
        return this;
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления блока с основными действиями пользователя",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PERSONAL_BLOCK), 10, 500));
        Assert.assertTrue("Не дождались появления лейбла 'О чем вы думаете?'",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_THOUGHTS), 10, 500));
    }
}
