package com.roman.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeUserAvatarTest extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }

    @Test
    public void testChangeAvatar() throws InterruptedException {
        logger.info("avatar before:");
        app.takeScreenshot();
        app.getHeader().clickOnAvatar();
        app.getSession().openUserProfileFromDropDown();
        app.getSession().goToAtlassianAccount();
        app.getSession().addPictureAndCloseWindow();
        logger.info("avatar after:");
        app.takeScreenshot();
    }


}
