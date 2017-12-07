package core.groupPages;

import core.HelperBase;
import model.Group;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by germanium on 30.11.17.
 */
public class GroupCreatePage extends HelperBase {

    private static final By FIELD_NAME = By.id("field_name");
    private static final By FIELD_DESCRIPTION = By.id("field_description");
    private static final By FIELD_SUBCATEGORY = By.id("field_pageMixedCategory");
    private static final By FIELD_AGE= By.id("field_ageRestriction");
    private static final By BUTTON_CREATE = By.id("hook_FormButton_button_create");




        public GroupCreatePage(WebDriver driver) {
            super(driver);
        }

    protected void check() {
        Assert.assertTrue("Не дождались поля ввода названия",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(FIELD_NAME), 10, 500));
    }


    public void typeGroupName(Group group) {
        type(group.getName(), FIELD_NAME);
    }
    public void typeDescription(Group group) {
        type(group.getDescription(), FIELD_DESCRIPTION);
    }
    public void setSubcategory(Group group) {
        click(FIELD_SUBCATEGORY);
        new Select(driver.findElement(FIELD_SUBCATEGORY)).selectByVisibleText(group.getCategory());
    }

    public void setAgeRestriction(Group group) {
        click(FIELD_AGE);
        new Select(driver.findElement(FIELD_AGE)).selectByVisibleText(group.getAgeRestriction());
    }
    public void clickCreate(){
        click(BUTTON_CREATE);
    }


}
