package core.examples;

import core.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Пример страницы, второй/новый дизайн
 */
public class ExamplePageNew extends BasePage implements ExampleInterface {

    public ExamplePageNew(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public boolean isSmthgPresent() {
        return false;
    }
}
