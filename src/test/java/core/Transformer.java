package core;

import core.wrapers.CommentWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Transformer {

    public static List<CommentWrapper> wrapComments(List<WebElement> elements, WebDriver driver) {
        if (elements.isEmpty()) {
            return Collections.emptyList();
        }

        List<CommentWrapper> comments = new ArrayList<>();

        for (WebElement element : elements) {
            comments.add(new CommentWrapper(element));
        }

        return comments;
    }
}
