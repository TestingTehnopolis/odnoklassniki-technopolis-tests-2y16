package core.Pages;

import core.HelperBase;
import core.Layers.AvatarLayer;
import core.Layers.NoteLayer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserMainPage extends HelperBase {

    private static final By USER_NAME = By.xpath(".//*[contains(@class, 'mctc_name_tx')]");
    private static final By SMALL_NOTE_FORM = By.xpath("//*[contains(@class,'posting-form_itx_dec itx_w')]");
    private static final By CREATED_NOTE = By.xpath("//*[contains(@class,'media-text_cnt_tx emoji-tx textWrap')]");
    private static final By GROUPS = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");
    private static final By USER_AVATAR = By.xpath(".//*[@class='card_wrp']");
    private static final By USER_LINK = By.xpath("//*[@id=\"hook_Block_MiddleColumnTopCardUser\"]/div/div/div[1]/div/span[1]/a");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Нет иконки пользователя",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(UCARD), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет username",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(USER_NAME), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет кнопки групп",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(GROUPS), timeOutInSeconds, sleepInMilliSeconds));
    }

    public GroupsMainPage clickGroupsOnToolbar() {
        Assert.assertTrue("Не найден элемент создания группы в тулабре", isElementVisible(GROUPS));
        click(GROUPS);
        return new GroupsMainPage(driver);
    }

    public String getUserName() {
        Assert.assertTrue("Не найден элемент с username", isElementVisible(USER_NAME));
        WebElement name = getElement(USER_NAME);
        return name.getText();
    }

    public String getUserLink(){
        Assert.assertTrue("Не найден id", isElementVisible(USER_LINK));
        WebElement link = getElement(USER_LINK);
        return link.getAttribute("href");
    }

    public NoteLayer openFullNoteForm() {
        Assert.assertTrue("Не найден элемент открытия заметок", isElementVisible(SMALL_NOTE_FORM));
        click(SMALL_NOTE_FORM);
        return new NoteLayer(driver);
    }

    public String returnCreatedNoteText() {
        Assert.assertTrue("Не найдена созданная заметка", isElementVisible(CREATED_NOTE));
        return getElement(CREATED_NOTE).getText();
    }

    public AvatarLayer clickOnAvatar() {
        Assert.assertTrue("Не найден аватар", isElementVisible(USER_AVATAR));
        click(USER_AVATAR);
        return new AvatarLayer(driver);
    }
}
