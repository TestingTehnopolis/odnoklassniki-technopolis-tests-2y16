package core.pages;

import core.promises.AddToFriendsPromise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchMainPage extends HelperBase {

    private static final By PEOPLE_TAB = By.xpath(".//*[contains(@data-aid,'PS_Click_Tab_Users')]");

    private static final By SEARCH_BY_ID = By.xpath(".//*[@id='field_refs']");

    SearchMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(PEOPLE_TAB)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(PEOPLE_TAB));
    }

    public SearchMainPage clickPeopleTab() {
        click(PEOPLE_TAB);
        return this;
    }

    public AddToFriendsPromise sendRequestToFriend(String fullName) throws InterruptedException {
        By addToFriendBtn = By.xpath(".//*[contains(@hrefattrs,'st._aid=LS_User_name') and text()='"
                + fullName
                + "']/ancestor::*[contains(@class,'ucard-v')]//*[contains(@class,'button')]");

        scrollWithOffset(PEOPLE_TAB, 0, -200);
        Thread.sleep(1000);
        click(addToFriendBtn);

        return new AddToFriendsPromise(driver);
    }

    public SearchMainPage clickSearchById() {
        click(SEARCH_BY_ID);
        return this;
    }

    public UserMainPage openUserPage(String fullName) throws InterruptedException {
        By addToFriendBtn = By.xpath(".//*[contains(@hrefattrs,'st._aid=LS_User_name') and text()='"
                + fullName
                + "']");


        scrollWithOffset(PEOPLE_TAB, 0, -200);
        Thread.sleep(1000);
        click(addToFriendBtn);

        return new UserMainPage(driver);
    }
}
