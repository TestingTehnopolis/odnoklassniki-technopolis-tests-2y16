package core.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Трансформер списка вебелементов в список ExampleWrapper
 */
class ExampleTransformer {

    public static List<ExampleWrapper> wrap(List<WebElement> elements, WebDriver driver) {
        if (elements.isEmpty()) {
            return Collections.<ExampleWrapper>emptyList();
        }
        List<ExampleWrapper> comments = new ArrayList<ExampleWrapper>();
        for (WebElement comment : elements) {
            comments.add(new ExampleWrapper(comment, driver));
        }
        return comments;
    }
}
