package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс предоставляет методы для действия на странице другого пользователя.
 */
public class DestinationUserPage extends PageBase {

    //базовые элементы страницы
    private static final By BTN_MAKE_GIFT = By.xpath(".//a[@id='action_menu_send_gift_a']");
    private static By USER_PAGE_TITLE;

    private static final By BTN_WRITE_MSG = By.id("action_menu_write_message_button_a");


    public DestinationUserPage(WebDriver driver, TestBot destinationUser) {
        super(driver);
        USER_PAGE_TITLE = By.xpath(".//h1[contains(@class,'mctc_name_tx bl') and contains(text(), '" +
                destinationUser.getLogin().toLowerCase() +
                "')]");

        customCheck();
    }

    public DestinationUserPage clickWriteMsg() {
        Assert.assertTrue("Не появилась кнопка \"Написать сообщение\"",
                isElementVisible(BTN_WRITE_MSG));
        click(BTN_WRITE_MSG);

        return this;
    }

    @Override
    protected void check() {
        /**
         * {@link DestinationUserPage#customCheck()}
         */
    }

    private void customCheck() {
        Assert.assertTrue("Не дождались появления ссылки \"Подарить подарок\"",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_MAKE_GIFT), 10, 500));
        //проверим что мы на страице нужного пользователя
        Assert.assertTrue("Не дождались появления нужного заголовка профиля",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(USER_PAGE_TITLE), 10, 500));
    }
}
