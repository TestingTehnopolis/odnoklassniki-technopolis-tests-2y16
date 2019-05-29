package core.examples;

import org.openqa.selenium.WebDriver;

/**
 * Фабрика
 */
public class ExampleFactory {

    public ExampleInterface get(WebDriver driver) {
        //условие
        if (isSmthgPresent(driver)) {
            return new ExamplePage(driver);
        } else {
            return new ExamplePageNew(driver);
        }
    }

    private boolean isSmthgPresent(WebDriver driver) {
        //здесь должен быть код, который определит на какой странице мы находимся ExamplePage или ExamplePageNew
        return true;
    }
}
