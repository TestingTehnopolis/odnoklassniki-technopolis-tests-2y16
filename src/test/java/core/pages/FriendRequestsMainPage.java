package core.pages;

import model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FriendRequestsMainPage extends HelperBase implements IFriendRequestsMainPage {

    private static final By COMPACT_PROFILE = By.xpath(".//*[@class='compact-profile']");

    public FriendRequestsMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(COMPACT_PROFILE)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(COMPACT_PROFILE));
    }

    @Override
    public boolean isRequestPresent(TestBot testBot) {
        By addToFriendBtn = By.xpath(
                ".//*[contains(@hrefattrs,'st.friendId=" +
                        testBot.getProfileId() +
                        "') and text()='" +
                        testBot.getFullName() +
                        "']/ancestor::*[contains(@class,'ucard-w')]//*[contains(@class,'js-entity-accept')]");

        return isElementPresent(addToFriendBtn);
    }
}
