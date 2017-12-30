package core.Pages;

import core.HelperBase;
import core.Layers.ChoiceTypeOfGroupLayer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupsMainPage extends HelperBase {

    private static final By CREATE_NEW_GROUP = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");

    public GroupsMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки созданиия новой группы",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_GROUP), timeOutInSeconds, sleepInMilliSeconds));
    }

    public ChoiceTypeOfGroupLayer clickCreateGroup() {
        Assert.assertTrue("Нет кнопки создания группы", isElementVisible(CREATE_NEW_GROUP));
        click(CREATE_NEW_GROUP);
        return new ChoiceTypeOfGroupLayer(driver);
    }
}
