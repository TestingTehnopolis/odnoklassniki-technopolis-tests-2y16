package core.Pages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tFNiYaFF on 30.12.2017.
 */
public class CreatedGroupPage extends HelperBase {

    private static final By GROUP_NAME = By.xpath("//span[contains(@class, 'mctc_name_holder')]");

    public CreatedGroupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет имени",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(GROUP_NAME), timeOutInSeconds, sleepInMilliSeconds));
    }

    public String getGroupName() {
        Assert.assertTrue("Нет кнопки создания группы", isElementVisible(GROUP_NAME));
        return getElement(GROUP_NAME).getText();
    }
}
