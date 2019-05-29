package core.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleWrapper {

    private WebElement element;
    private WebDriver driver;

    private static final By SMILE_IN_MESSAGE = By.xpath(".//img[contains(@class,'usmile')]");

    public ExampleWrapper(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }

    /**
     * Возвращает true если отображается что-то
     */
    public boolean isSmthgDisplayed() {
        return element.findElement(SMILE_IN_MESSAGE).isDisplayed();
    }
}
