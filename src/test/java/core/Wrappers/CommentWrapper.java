package core.Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Никита on 28.12.2017.
 */

public class CommentWrapper {

    private static final By COMMENT = By.xpath(".//*[contains(@class, 'comments_text')]//div");
    private static final By OWNER_FULL_NAME = By.xpath(".//*[@class='comments_author']");

    private String comment;
    private String ownerFullName;

    public CommentWrapper(WebElement element) {
        comment = element.findElement(COMMENT).getText();
        ownerFullName = element.findElement(OWNER_FULL_NAME).getText();
    }

    public String getComment() {
        return comment;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }
}

