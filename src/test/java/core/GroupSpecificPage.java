package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupSpecificPage extends HelperBase {
    private static final By CREATE_PHOTO_COMPETITION = By.xpath(".//*[contains(@hrefattrs,'st.layer.cmd=PopLayerCreatePhotoCompetition')]");
    private static final By ADD_BOOKMARK = By.xpath(".//*[contains(@href,'cmd=AddBookmark')]");
    private static final By INVITE_FRIENDS = By.xpath(".//*[@id='hook_Block_LeftColumnTopCardAltGroup']//*[contains(@hrefattrs,'st.layer.cmd=InviteFriendsToGroup2')]");
    private static final By INVITE_SELECTABLE_FRIEND = By.xpath(".//*[@id='listBlockPanelInviteFriendsToGroup2FriendsList']//*[@data-id and contains(@class,'selectable-card')]");
    private static final By INVITE_SELECT_ALL = By.xpath(".//*[@id='field_selectedAll']");

    private static final String CREATE_NEW_PHOTO_COMPETITION_NAME_ID = "field_name";
    private static final String CREATE_NEW_PHOTO_COMPETITION_TILL_ID = "field_till";
    private static final String CREATE_NEW_PHOTO_COMPETITION_SUBMIT_ID = "hook_FormButton_button_create_comp";
    private static final String CREATE_FRIEND_INVITATION_SUBMIT_ID = "hook_FormButton_button_invite";

    public GroupSpecificPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки созданиия фотоконкурса",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(CREATE_PHOTO_COMPETITION), 10, 500));
    }

    /**
     * Нажимаем создать фотоконкурс на странице группы
     */
    public void clickCreatePhotoCompetition() {
        Assert.assertTrue("Не найден элемент создания фотоконкурса", isElementPresent(CREATE_PHOTO_COMPETITION));
        driver.findElement(CREATE_PHOTO_COMPETITION).click();
    }

    /**
     * Вводим название фотоконкурса
     */
    public void typePhotoCompetitionName(String photoCompetitionName) {
        type(photoCompetitionName, By.id(CREATE_NEW_PHOTO_COMPETITION_NAME_ID));
    }

    /**
     * Вводим дату окончания фотоконкурса
     */
    public void typePhotoCompetitionTillDate(String photoCompetitionTillDate) {
        type(photoCompetitionTillDate, By.id(CREATE_NEW_PHOTO_COMPETITION_TILL_ID));
        sendEnterKey(By.id(CREATE_NEW_PHOTO_COMPETITION_TILL_ID));
    }

    /**
     * Нажимаем создать фотоконкурс на леере
     */
    public GroupSpecificAlbumPage clickSubmitCreatePhotoCompetition() {
        click(By.id(CREATE_NEW_PHOTO_COMPETITION_SUBMIT_ID));
        return new GroupSpecificAlbumPage(driver);
    }

    /**
     * Нажимаем кнопку добавления в закладки
     */
    public void clickAddBookmark() {
        Assert.assertTrue("Не найден элемент добавления в закладки", isElementPresent(ADD_BOOKMARK));
        driver.findElement(ADD_BOOKMARK).click();
    }

    /**
     * Проверяем, имеется ли друг, доступный для приглашения
     * @boolean имеется ли доступный друг
     */
    public boolean isSelectableFriendPresent() {
        return isElementPresent(INVITE_SELECTABLE_FRIEND);
    }

    /**
     * Нажимаем кнопку приглашения друзей
     */
    public void clickInviteFriends() {
        Assert.assertTrue("Не найден элемент приглашения друзей", isElementPresent(INVITE_FRIENDS));
        driver.findElement(INVITE_FRIENDS).click();
    }

    /**
     * Выбираем всех друзей (если есть друзья для приглашения)
     */
    public void selectAllForInvitation() {
        Assert.assertTrue("Не найдены друзья для приглашения", isSelectableFriendPresent());
        driver.findElement(INVITE_SELECT_ALL).click();
    }

    /**
     * Подвтерждаем приглашение друзей
     */
    public GroupSpecificPage submitFriendInvitation() {
        click(By.id(CREATE_FRIEND_INVITATION_SUBMIT_ID));
        return new GroupSpecificPage(driver);
    }

    /**
     * Получаем toolbar
     */
    public ToolbarPartial getToolbar() {
        return new ToolbarPartial(driver);
    }
}
