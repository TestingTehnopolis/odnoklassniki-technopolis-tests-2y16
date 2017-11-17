package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserMainPage extends HelperBase {


    private static final By FRIENDS_ON_TOOLBAR = By.xpath(".//*[contains(@class, 'toolbar_decor')]//*[contains(@data-l,'t,friends')]");
    private static final By GROUP_ON_TOOLBAR = By.xpath(".//*[contains(@hrefattrs,'st._aid=NavMenu_User_AltGroups')]");
    private static final By USER_AVATAR = By.xpath(".//*[@class='card_wrp']");
    private static final By SEARCH_INPUT_FIELD = By.xpath(".//*[@id='field_query']");
    private static final By LUPA = By.xpath(".//*[@class='toolbar_search_lupa']");
    private static final By SECONDARY_DROPDOWN_BTN = By.xpath(".//*[contains(@class, 'secondary-dropdown')]");
    private static final By REVOKE_FRIEND_REQUEST_BTN = By.xpath(".//*[contains(@href, 'st._aid=FriendTopCard_JoinDropdown_REVOKE')]");
    private static final By WRITE_MESSAGE_BTN = By.xpath(".//*[@id='action_menu_write_message_button_a']");
    private static final By SETTINGS_BTN = By.xpath(".//*[@data-l='t,USER_EDIT_CONFIG']");


    UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(USER_AVATAR)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(USER_AVATAR));
    }

    public void clickGroupsOnToolbar() {
        click(GROUP_ON_TOOLBAR);
    }

    public SearchMainPage search(String query) {
        type(query, SEARCH_INPUT_FIELD);
        click(LUPA);
        return new SearchMainPage(driver);
    }

    public UserMainPage revokeRequestToFriend() {
        click(SECONDARY_DROPDOWN_BTN);
        click(REVOKE_FRIEND_REQUEST_BTN);

        return this;
    }

    public FriendsMainPage clickFriendsOnToolbar() {
        click(FRIENDS_ON_TOOLBAR);

        return new FriendsMainPage(driver);
    }

    public PhotoMainPage clickOnAvatar() {
        click(USER_AVATAR);
        return new PhotoMainPage(driver);
    }

    public MessageMainPage clickWriteMessage(){
        click(WRITE_MESSAGE_BTN);
        return new MessageMainPage(driver);
    }

    public SettingsMainPage clickOnMySettings(){
        click(SETTINGS_BTN);
        return new SettingsMainPage(driver);
    }
}
