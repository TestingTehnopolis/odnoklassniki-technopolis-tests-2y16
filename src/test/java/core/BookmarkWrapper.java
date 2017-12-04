package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookmarkWrapper {

    private final WebElement element;

    private static final By TEXT_LINK = By.xpath(".//a[contains(@class, 'o') and not(contains(@class, 'dblock'))]");

    public BookmarkWrapper(final WebElement element) {
        this.element = element;
    }

    /**
     * Получение названия сущности, к которой относится закладка
     * @return String название сущности
     */
    public String getEntityName() {
        return element.findElement(TEXT_LINK).getText();
    }
}
