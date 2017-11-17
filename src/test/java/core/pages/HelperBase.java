package core.pages;

import org.openqa.selenium.*;

abstract class HelperBase {
    WebDriver driver;
    private boolean acceptNextAlert = true;

    HelperBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    abstract void check();

    void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    void click(By locator) {
        driver.findElement(locator).click();
    }

    boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    boolean isElementSelected(By by){
        return driver.findElement(by).isSelected();
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    void scrollWithOffset(By locator, int x, int y) {
        WebElement element = driver.findElement(locator);

        String code = "window.scroll(" + (element.getLocation().x + x) + ","
                + (element.getLocation().y + y) + ");";

        ((JavascriptExecutor) driver).executeScript(code, element, x, y);

    }
}
