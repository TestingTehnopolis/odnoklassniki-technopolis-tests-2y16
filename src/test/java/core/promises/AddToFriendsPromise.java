package core.promises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class AddToFriendsPromise {

    private static final Logger LOGGER = Logger.getLogger(AddToFriendsPromise.class);
    private static final By ACTION_MENU_FRIENDSHIP_REQUEST_SENT = By.xpath(".//*[@class='gs_result_i_status' and @style='display: block;']");
    private final WebDriver driver;

    public AddToFriendsPromise(WebDriver driver) {
        this.driver = driver;
    }

    public void andRequestSend() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(ACTION_MENU_FRIENDSHIP_REQUEST_SENT));
        LOGGER.info("Запрос дружить отправлен");
    }
}
