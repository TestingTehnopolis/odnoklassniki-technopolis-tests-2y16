package core;

import core.pages.FriendRequestsMainPage;
import core.pages.FriendRequestsMainPageNew;
import core.pages.IFriendRequestsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageFactory {


    private static final By COMPACT_PROFILE_IMG = By.xpath(".//*[@class='compact-profile_img']");
    private static final By GUEST_BLOCK = By.xpath(".//*[@id='hook_Block_UserGuestsPortlet']");

    public static IFriendRequestsMainPage getFriendRequestsMainPage(WebDriver driver) {
        Assert.assertTrue(
                new WebDriverWait(driver, 10).until(d -> isElementPresent(driver, COMPACT_PROFILE_IMG)),
                "COMPACT_PROFILE_IMG not present"
        );

        boolean isNewFriendRequestsMainPage = isElementPresent(driver, GUEST_BLOCK);

        if (isNewFriendRequestsMainPage) {
            return new FriendRequestsMainPageNew(driver);
        } else {
            return new FriendRequestsMainPage(driver);
        }
    }

    private static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
