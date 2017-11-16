package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GroupMainPage extends HelperBase {

    private static final By CREATE_NEW_GROUP = By.xpath(".//*[contains(@href,'st._aid=UserGroups_createGroup')]");
    private static final By COMPACT_PROFILE_IMG = By.xpath(".//*[contains(@class,'compact-profile_img')]");

    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    void check() {
        new WebDriverWait(driver, 10).until(d -> isElementPresent(CREATE_NEW_GROUP));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_GROUP));
        new WebDriverWait(driver, 10).until(d -> isElementPresent(COMPACT_PROFILE_IMG));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(COMPACT_PROFILE_IMG));
    }

    public void clickCreateButton() {
        click(By.id("hook_FormButton_button_create"));
    }

    public void typeGroupName(String groupName) {
        type(groupName, By.id("field_name"));
    }

    public void clickCreateGroup() {
        Assert.assertTrue(isElementPresent(CREATE_NEW_GROUP), "Не найден элемент создания группы");
        click(CREATE_NEW_GROUP);
    }
}
