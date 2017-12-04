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

    public GroupSpecificPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return isElementPresent(CREATE_PHOTO_COMPETITION);
            }
        });

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_PHOTO_COMPETITION));
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
        type(photoCompetitionName, By.id("field_name"));
    }

    /**
     * Вводим дату окончания фотоконкурса
     */
    public void typePhotoCompetitionTillDate(String photoCompetitionTillDate) {
        type(photoCompetitionTillDate, By.id("field_till"));
        sendEnterKey(By.id("field_till"));
    }

    /**
     * Нажимаем создать фотоконкурс на леере
     */
    public void clickCreatePhotoCompetitionButton() {
        click(By.id("hook_FormButton_button_create_comp"));
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
    public void submitFriendInvitation() {
        click(By.id("hook_FormButton_button_invite"));
    }
}
