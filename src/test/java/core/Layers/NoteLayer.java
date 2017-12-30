package core.Layers;

import core.HelperBase;
import core.Pages.UserMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tFNiYaFF on 29.12.2017.
 */
public class NoteLayer extends HelperBase {

    private static final By FULL_NOTE_FORM = By.xpath("//*[contains(@class,'posting_itx emoji-tx h-mod js-ok-e ok-posting-handler')]");
    private static final By CREATE_NOTE_BUTTON = By.xpath("//*[contains(@class,'posting_submit button-pro')]");

    public NoteLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет поля ввода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(FULL_NOTE_FORM), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет кнопки создания",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(CREATE_NOTE_BUTTON), timeOutInSeconds, sleepInMilliSeconds));
    }

    public NoteLayer typeText(String text) {
        Assert.assertTrue("Нет поля ввода", isElementVisible(FULL_NOTE_FORM));
        type(text, FULL_NOTE_FORM);
        return new NoteLayer(driver);
    }

    public UserMainPage createNote() {
        Assert.assertTrue("Нет кнопки создания", isElementVisible(CREATE_NOTE_BUTTON));
        click(CREATE_NOTE_BUTTON);
        return new UserMainPage(driver);
    }
}
