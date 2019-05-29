package core.examples;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;

/**
 * Пример страницы
 */
public class ExampleCommonPage extends BasePage {

    private static final By COMMENT = By.xpath(".//*[@id = 'Комментарий']");

    public ExampleCommonPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    /**
     * Клик на кнопку
     */
    public ExamplePromise addComment() {
        click(COMMENT);
        return new ExamplePromise(driver);
    }

    /**
     * Возвращает список элементов
     *
     * @return список элементов (обертки)
     */
    public List<ExampleWrapper> getComments() {
        if (isElementPresent(COMMENT)) {
            return ExampleTransformer.wrap(driver.findElements(COMMENT), driver);
        }
        return Collections.emptyList();
    }
}
