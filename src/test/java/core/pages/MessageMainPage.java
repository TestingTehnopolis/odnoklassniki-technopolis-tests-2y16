package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageMainPage extends HelperBase{

    private static final By NOT_FRIEND_BLOCKED = By.xpath(".//*[@data-type='NOT_FRIEND_BLOCKED']");

    MessageMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {

    }

    public boolean isMessagesNotAllowed(){
        return isElementPresent(NOT_FRIEND_BLOCKED);
    }
}
