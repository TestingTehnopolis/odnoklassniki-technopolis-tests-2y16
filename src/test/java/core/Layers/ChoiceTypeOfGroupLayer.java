package core.Layers;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tFNiYaFF on 30.12.2017.
 */
public class ChoiceTypeOfGroupLayer extends HelperBase {

    private static final By INTEREST_GROUP = By.xpath(".//*[contains(@class,'create-group-dialog_img __interest')]");

    public ChoiceTypeOfGroupLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет кнопки создания группы по интересам",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(INTEREST_GROUP), timeOutInSeconds, sleepInMilliSeconds));
    }

    public CreateGroupLayer clickInterestGroup() {
        Assert.assertTrue("Нет типа группы по интересам", isElementVisible(INTEREST_GROUP));
        click(INTEREST_GROUP);
        return new CreateGroupLayer(driver);
    }
}
