package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroupFormLayer extends HelperBase {

    private static final By CREATE_BUTTON = By.id("hook_FormButton_button_create");
    private static final By NAME = By.id("field_name");
    private static final By NAME_FORM = By.xpath("//*[@id='field_name']/parent::*");


    public GroupFormLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public void clickCreateButton() {
        Assert.assertTrue("Не найден элемент создания группы", isElementPresent(CREATE_BUTTON));
        click(CREATE_BUTTON);
    }

    public GroupPage create() {
        clickCreateButton();
        return new GroupPage(driver);
    }

    public GroupFormLayer typeGroupName(String groupName) {
        Assert.assertTrue("Не найдено поле заполнения названия группы", isElementPresent(NAME));
        type(groupName, NAME);
        return this;
    }

    public FieldFillingErrorPromise getFieldFillingErrorPromise() {
        return new FieldFillingErrorPromise(this);
    }

    public final class FieldFillingErrorPromise {

        private final By ERROR_MESSAGE = By.xpath("//*[contains(@class, 'input-e')]");
        GroupFormLayer groupFormLayer;

        FieldFillingErrorPromise(GroupFormLayer groupFormLayer) {
            this.groupFormLayer = groupFormLayer;
        }

        public GroupFormLayer andNameErrorPresent() {
            Assert.assertTrue("Не найден элемент формы для поля заполнения имени", isElementPresent(NAME_FORM));
            Assert.assertTrue("Не найдено сообщение об ошибке", isElementPresent(getElement(NAME_FORM), ERROR_MESSAGE));
            return groupFormLayer;
        }
    }
}
