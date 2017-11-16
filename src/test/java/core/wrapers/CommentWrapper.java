package core.wrapers;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommentWrapper {

    private static final By COMMENT = By.xpath(".//*[contains(@class, 'comments_text')]//div");
    private static final By OWNER_FULL_NAME = By.xpath(".//*[@class='comments_author']"); //[contains(@hrefattrs, 'st.friendId')]

    private String comment;
    private String ownerFullName;

    public CommentWrapper(WebElement element) {
        comment = element.findElement(COMMENT).getText();
        Preconditions.checkNotNull(comment, "Текст комментария не может быть пустым");
        ownerFullName = element.findElement(OWNER_FULL_NAME).getText();
    }

    public String getComment() {
        return comment;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }
}
