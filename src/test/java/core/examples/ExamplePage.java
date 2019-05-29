package core.examples;

import core.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Пример страницы, первый/старый дизайн
 */
public class ExamplePage extends BasePage implements ExampleInterface {

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public boolean isSmthgPresent() {
        return false;
    }
}
