package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Это обёртка для популярных групп на главной странице групп.
 */
public class UserGroupWrapper extends HelperBase {

    private final WebElement element;

    private static final By NAME = By.xpath(".//*[contains(@class,'o two-lines')]");


    /**
     * @param driver  Драйвер браузера.
     * @param element Элемент, который соответствует популярной группе.
     */
    public UserGroupWrapper(WebDriver driver, WebElement element) {
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

}
