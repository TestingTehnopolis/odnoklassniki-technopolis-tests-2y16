package tests;

import core.*;
import core.groupPages.*;
import model.Group;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by germanium on 30.11.17.
 */

public class GroupTest extends TestBase{

    private static Group group;

    @Test
    public void testGroupCreation() throws Exception{

        String name = String.valueOf(new Random().nextInt(100000));

        group  = new Group(name, "desc", "Music", "None");

        doLogin();

        new UserMainPage(driver).clickGroupsOnToolbar();

        new GroupMainPage(driver).clickCreateButton();

        new GroupTypeChoice(driver).clickStoreType();

        GroupCreatePage groupCreatePage = new GroupCreatePage(driver);

        groupCreatePage.typeGroupName(group);

        groupCreatePage.typeDescription(group);

        groupCreatePage.setSubcategory(group);

        groupCreatePage.setAgeRestriction(group);

        groupCreatePage.clickCreate();

        new GroupCreatedPage(driver).clickGroupName(group);
//        TimeUnit.SECONDS.sleep(2);
        Assert.assertTrue(new GroupCertainPage(driver).isGroupCreated(group));

    }

}
