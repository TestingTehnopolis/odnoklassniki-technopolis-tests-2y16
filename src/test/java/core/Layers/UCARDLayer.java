package core.Layers;

import core.HelperBase;
import core.Pages.LoginMainPage;
import core.Pages.SettingsMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Никита on 28.12.2017.
 */
public class UCARDLayer extends HelperBase {

    private static final By LOGOUT_BUTTON = By.xpath("//*[contains(@data-l, 't,logoutCurrentUser')]");
    private static final By CHANGE_SETTINGS = By.xpath("//*[contains(@class,'u-menu_a') and contains(@href,'settings')]");
    private static final By LOGOUT_CONFIRM = By.xpath("//*[contains(@data-l, 't,confirm') and contains(@value, 'Выйти')]");

    public UCARDLayer(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Нет кнопки выхода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет кнопки настроек",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(CHANGE_SETTINGS), timeOutInSeconds, sleepInMilliSeconds));
    }

    public UCARDLayer clickLogout() {
        Assert.assertTrue("Не найдена кнопка logout", isElementVisible(LOGOUT_BUTTON));
        click(LOGOUT_BUTTON);
        return new UCARDLayer(driver);
    }

    public LoginMainPage confirmLogout() {
        Assert.assertTrue("Не найдена кнопка подиверждения выхода", isElementVisible(LOGOUT_CONFIRM));
        click(LOGOUT_CONFIRM);
        return new LoginMainPage(driver);
    }

    public SettingsMainPage openSettings() {
        Assert.assertTrue("Не найдена кнопка изменения настроек", isElementVisible(CHANGE_SETTINGS));
        click(CHANGE_SETTINGS);
        return new SettingsMainPage(driver);
    }
}
