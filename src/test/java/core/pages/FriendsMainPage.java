package core.pages;

import core.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FriendsMainPage extends HelperBase {

    private static final By COMPACT_PROFILE = By.xpath(".//*[@class='compact-profile']");
    private final static By FRIEND_REQUESTS = By.xpath(".//*[contains(@hrefattrs, 'st.cmd=userFriendRequest') and contains(@hrefattrs, 'UserMain_Friends_FriendRequests')]");

    FriendsMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(COMPACT_PROFILE)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(COMPACT_PROFILE));
    }

    public IFriendRequestsMainPage clickFriendRequests() {
        click(FRIEND_REQUESTS);
        return PageFactory.getFriendRequestsMainPage(driver);
    }
}
