package core.examples;

import org.openqa.selenium.WebDriver;

/**
 * Промис
 */
public class ExamplePromise {

    private final WebDriver driver;

    /**
     * Конструктор
     */
    public ExamplePromise(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Ожидание №1
     *
     * @return
     */
    public ExamplePage andExamplePageOpen() {
        return new ExamplePage(driver);
    }

    /**
     * Ожидание №2
     *
     * @return
     */
    public ExamplePageNew andExamplePageNewOpen() {
        return new ExamplePageNew(driver);
    }
}


