package core.groupPages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupMainPage extends HelperBase {

    private static final By BUTTON_NEWGROUP = By.xpath(".//*[contains(@class,'create-group')]");


    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки созданиия новой группы",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEWGROUP), 10, 500));

    }

    public void clickCreateButton() {
        click(BUTTON_NEWGROUP);
    }

    public void typeGroupName(String groupName) {
        type(groupName, By.id("field_name"));
    }

    public void clickInterestGroup() {
        click(By.xpath(".//*[contains(@class,'create-group-dialog_img __interest')]"));
    }

    public void clickCreateGroup() {
        Assert.assertTrue("Не найден элемент создания группы", isElementPresent(BUTTON_NEWGROUP));
        driver.findElement(BUTTON_NEWGROUP).click();
    }

}

