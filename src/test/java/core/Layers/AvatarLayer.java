package core.Layers;

import core.Wrappers.CommentWrapper;
import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

import java.util.List;

import static core.Transformer.wrapComments;

/**
 * Created by Никита on 28.12.2017.
 */
public class AvatarLayer extends HelperBase {

    private static final By PHOTO = By.xpath(".//*[@id='photo-layer_img_w']");
    private static final By PHOTO_LAYER_INFO = By.xpath(".//*[@class='photo-layer_info']");
    private static final By COMMENT_INPUT = By.xpath(".//div[contains(@class,'js-comments_add')]");
    private static final By COMMENT = By.xpath(".//*[@class='comments_lst_cnt']//*[@class='comments_i']");
    private static final By COMMENTS_LIST = By.xpath(".//*[@class='comments_lst_cnt']");
    private static final By SUBMIT_BUTTON = By.xpath(".//*[@class='button-pro form-actions_yes']");

    public AvatarLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Нет фото",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PHOTO), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет лейера с фото",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PHOTO_LAYER_INFO), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет комментариев",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(COMMENTS_LIST), timeOutInSeconds, sleepInMilliSeconds));
        // Остальное не видно при создании
    }

    public AvatarLayer typeComment(String comment) throws InterruptedException {
        Assert.assertTrue("Нет списка коментариев", isElementVisible(COMMENTS_LIST));
        new Actions(driver).sendKeys(driver.findElement(COMMENTS_LIST), Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue("Нет поля ввода комментария", isElementVisible(COMMENT_INPUT));
        type(comment, COMMENT_INPUT);
        return new AvatarLayer(driver);
    }

    public AvatarLayer submitComment() {
        Assert.assertTrue("Нет кнопки отправки", isElementVisible(SUBMIT_BUTTON));
        click(SUBMIT_BUTTON);
        return new AvatarLayer(driver);
    }

    public boolean isCommentPresent(String comment, String name) {
        for (CommentWrapper commentWrapper : getComments()) {
            if (commentWrapper.getComment().equals(comment)
                    && commentWrapper.getOwnerFullName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private List<CommentWrapper> getComments() {
        Assert.assertTrue("Нет комментария", isElementVisible(COMMENT));
        List<WebElement> comments = driver.findElements(COMMENT);
        return wrapComments(comments);
    }
}
