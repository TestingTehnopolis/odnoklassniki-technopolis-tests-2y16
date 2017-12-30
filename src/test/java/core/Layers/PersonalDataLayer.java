package core.Layers;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Никита on 29.12.2017.
 */
public class PersonalDataLayer extends HelperBase {

    private static final By SETTINGS_ACCOUNT_NAME = By.xpath("//*[contains(@id,'field_name')]");
    private static final By SETTINGS_SAVE_BUTTON = By.xpath("//*[contains(@id,'hook_FormButton_button_savePopLayerEditUserProfileNew')]");

    public PersonalDataLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет поля воода имени",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(SETTINGS_ACCOUNT_NAME), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет кнопки сохранения",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(SETTINGS_SAVE_BUTTON), timeOutInSeconds, sleepInMilliSeconds));
    }

    public CloseSettingsAfterSaveLayer clickSaveButton() {
        Assert.assertTrue("Нет кнопки сохранения", isElementVisible(SETTINGS_SAVE_BUTTON));
        click(SETTINGS_SAVE_BUTTON);
        return new CloseSettingsAfterSaveLayer(driver);
    }

    public PersonalDataLayer typeNewName(String newName) {
        Assert.assertTrue("Нет поля ввода", isElementVisible(SETTINGS_ACCOUNT_NAME));
        type(newName, SETTINGS_ACCOUNT_NAME);
        return new PersonalDataLayer(driver);
    }
}
