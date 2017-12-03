package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Это обёртка для популярных групп на главной странице групп.
 */
public class GroupWrapper extends HelperBase {

    private final WebElement element;

    private static final By NAME = By.xpath(".//*[contains(@class,'group-name-link')]");
    private static final By SUBSCRIBERS_CNT = By.xpath("//*[contains(@class, 'lp-t') and (contains(text(), 'участников') or contains(text(), 'участник'))]");

    /**
     * @param driver  Драйвер браузера.
     * @param element Элемент, который соответствует популярной группе.
     */
    public GroupWrapper(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
    }

    @Override
    protected void check() {

    }

    /**
     * @return элемент популярной группы.
     */
    public WebElement getElement() {
        return element;
    }

    /**
     * @return Имя популярной группы.
     */
    public String getName() {
        return element.findElement(NAME).getText();
    }

    /**
     * @return Текст с количеством подписчиков популярной группы.
     */
    public String getSubscribersCnt() {
        return element.findElement(SUBSCRIBERS_CNT).getText();
    }
}
