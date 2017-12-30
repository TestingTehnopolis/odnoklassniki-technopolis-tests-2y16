package core.Layers;

import core.HelperBase;
import core.Pages.SettingsMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tFNiYaFF on 30.12.2017.
 */
public class CloseSettingsAfterSaveLayer extends HelperBase {

    private static final By SETTINGS_CLOSE_AFTER_SAVE_BUTTON = By.xpath("//*[contains(@id,'buttonId_button_close')]");

    public CloseSettingsAfterSaveLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет кнопки закрытия",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(SETTINGS_CLOSE_AFTER_SAVE_BUTTON), timeOutInSeconds, sleepInMilliSeconds));
    }

    public SettingsMainPage closeSettings() {
        Assert.assertTrue("Нет кнопки закртия окна сохранерия", isElementVisible(SETTINGS_CLOSE_AFTER_SAVE_BUTTON));
        click(SETTINGS_CLOSE_AFTER_SAVE_BUTTON);
        return new SettingsMainPage(driver);
    }
}
