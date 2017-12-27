package core;

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
    private static final By NOTE_AREA = By.xpath(".//div[text() = 'Напишите заметку']");

    private static final By ICON_MSG = By.id("msg_toolbar_button");
    private static final By ICON_LEAD_TO_EXIT_LAYER = By.xpath(".//div[contains(@class, 'toolbar_dropdown_w h-mod')]");
    private static final By LAYER_EXIT = By.xpath(".//div[contains(@class, 'toolbar_accounts-user-info')]");
    private static final By LAYER_CONFIRM_EXIT = By.xpath(".//div[text()='Выход с сайта']");
    private static final By BTN_EXIT = By.xpath(".//a[text()='Выйти']");
    private static final By BTN_CONFIRM_EXIT = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public UserMainPage goToDestinationUser(String id) {
        driver.get("https://ok.ru/profile/" + id + "/");
        return this;
    }

    public UserMainPage goToDialogs() {
        Assert.assertTrue("Не появилась иконка \"Сообщения\"",
                isElementVisible(ICON_MSG));
        click(ICON_MSG);

        return this;
    }

    public boolean isExitLayerVisible() {
        return explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_EXIT), 10, 500);
    }

    public UserMainPage openExitLayer() {
        Assert.assertTrue("Не появилась иконка, открывающая лейер с кнопкой выхода",
                isElementVisible(ICON_LEAD_TO_EXIT_LAYER));
        click(ICON_LEAD_TO_EXIT_LAYER);

        return this;
    }

    public UserMainPage clickBtnConfirmExit() {
        Assert.assertTrue("Не появилась кнопка для подтверждения выхода",
                isElementVisible(BTN_CONFIRM_EXIT));
        click(BTN_CONFIRM_EXIT);

        return this;
    }

    public UserMainPage clickBtnExit() {
        Assert.assertTrue("не появилась кнопка выхода из аккаунта",
                isElementVisible(BTN_EXIT));
        click(BTN_EXIT);

        return this;
    }

    public boolean isConfirmExitLayerVisible() {
        return explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_CONFIRM_EXIT), 10, 500);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления блока с основными действиями пользователя",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PERSONAL_BLOCK), 10, 500));
        Assert.assertTrue("Не дождались появления лейбла 'О чем вы думаете?'",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(NOTE_AREA), 10, 500));
    }
}
