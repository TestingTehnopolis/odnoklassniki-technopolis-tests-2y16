package core;

import core.Wrappers.CommentWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tFNiYaFF on 30.12.2017.
 */
public class Transformer {

    public static List<CommentWrapper> wrapComments(List<WebElement> elements) {
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
