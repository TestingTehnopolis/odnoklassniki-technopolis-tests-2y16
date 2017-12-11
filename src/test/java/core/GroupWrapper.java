package core;

import org.openqa.selenium.WebElement;

public class GroupWrapper {

    private final WebElement element;

    public GroupWrapper(final WebElement element) {
        this.element = element;
    }

    /**
     * Нажатие для перехода в группу
     */
    public void open() {
        element.click();
    }

    /**
     * Получение относительной ссылки на группу
     * @return String относительная ссылка
     */
    public String getGroupHref() {
        return element.getAttribute("href");
    }
}
