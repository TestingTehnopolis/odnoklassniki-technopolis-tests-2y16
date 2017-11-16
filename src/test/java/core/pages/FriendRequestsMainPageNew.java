package core.pages;

import model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FriendRequestsMainPageNew extends HelperBase implements IFriendRequestsMainPage {

    private static final By COMPACT_PROFILE = By.xpath(".//*[@class='compact-profile']");

    public FriendRequestsMainPageNew(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(COMPACT_PROFILE)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(COMPACT_PROFILE));
    }

    @Override
    public boolean isRequestPresent(TestBot testBot) {
        By addToFriendBtn = By.xpath(".//*[contains(@hrefattrs,'st._aid=LS_User_name') and text()='"
                + testBot.getFullName()
                + "']/ancestor::*[contains(@class,'ucard-v')]//*[contains(@class,'button')]");

        return isElementPresent(addToFriendBtn);
    }
}
