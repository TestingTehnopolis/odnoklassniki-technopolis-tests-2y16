package core.Layers;

import core.HelperBase;
import core.Pages.CreatedGroupPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tFNiYaFF on 29.12.2017.
 */
public class CreateGroupLayer extends HelperBase {

    private static final By CREATE_GROUP_BUTTON = By.id("hook_FormButton_button_create");
    private static final By GROUP_NAME_FIELD = By.id("field_name");


    public CreateGroupLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет поля ввода",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(GROUP_NAME_FIELD), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет кнопки создания",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(CREATE_GROUP_BUTTON), timeOutInSeconds, sleepInMilliSeconds));
    }

    public CreateGroupLayer typeGroupName(String groupName) {
        Assert.assertTrue("Нет поля ввода", isElementVisible(GROUP_NAME_FIELD));
        type(groupName, GROUP_NAME_FIELD);
        return new CreateGroupLayer(driver);
    }

    public CreatedGroupPage clickCreateButton() {
        Assert.assertTrue("Нет кнопки создания группы", isElementVisible(CREATE_GROUP_BUTTON));
        click(CREATE_GROUP_BUTTON);
        return new CreatedGroupPage(driver);
    }
}
