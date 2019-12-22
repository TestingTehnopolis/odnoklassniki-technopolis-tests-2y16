package core.pages;

import core.Transformer;
import core.wrapers.CommentWrapper;
import model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PhotoMainPage extends HelperBase {

    private static final By PHOTO = By.xpath(".//*[@id='photo-layer_img_w']");
    private static final By PHOTO_LAYER_INFO = By.xpath(".//*[@class='photo-layer_info']");
    private static final By ADD_COMMENT_BOX = By.xpath(".//*[@class='comments_add']");
    private static final By COMMENT_INPUT = By.xpath(".//div[contains(@class,'js-comments_add')]");
    private static final By COMMENT_SUBMIT_BTN = By.xpath(".//*[@data-l='t,submit']");
    private static final By COMMENT = By.xpath(".//*[@class='comments_lst_cnt']//*[@class='comments_i']");

    PhotoMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(PHOTO)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(PHOTO));
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(PHOTO_LAYER_INFO)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(PHOTO_LAYER_INFO));
    }

    public PhotoMainPage typeComment(String comment) throws InterruptedException {
        click(COMMENT_INPUT);
        type(comment, COMMENT_INPUT);
        return this;
    }

    public PhotoMainPage submitComment() {
        click(COMMENT_SUBMIT_BTN);
        return this;
    }

    public boolean isCommentPresent(String comment, TestBot testBot) {
        for (CommentWrapper commentWrapper : getComments()) {
            if (commentWrapper.getComment().equals(comment)
                    && commentWrapper.getOwnerFullName().equals(testBot.getFullName())) {
                return true;
            }
        }

        return false;
    }

    private List<CommentWrapper> getComments() {
        List<WebElement> comments = driver.findElements(COMMENT);
        return Transformer.wrapComments(comments, driver);
    }
}
