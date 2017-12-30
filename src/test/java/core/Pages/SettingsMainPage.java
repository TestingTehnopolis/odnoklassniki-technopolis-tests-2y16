package core.Pages;

import core.HelperBase;
import core.Layers.PersonalDataLayer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Никита on 28.12.2017.
 */
public class SettingsMainPage extends HelperBase {

    private static final By PERSONAL_DATA = By.xpath("//*[contains(@class,'user-settings_i_tx textWrap')]");

    public SettingsMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Нет персональной информации",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PERSONAL_DATA), timeOutInSeconds, sleepInMilliSeconds));
    }

    public PersonalDataLayer openPersonalData() {
        Assert.assertTrue("Не найден раздел персональной информации", isElementVisible(PERSONAL_DATA));
        click(PERSONAL_DATA);
        return new PersonalDataLayer(driver);
    }

}
