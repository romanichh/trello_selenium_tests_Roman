package com.roman.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest1 extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.isAvatarPresentOnHeader()) {
            app.logout();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {
        //clickLogin
        app.clickLoginLink();
        app.fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(app.isAvatarPresentOnHeader());
    }

    @Test
    public void testLoginAgain() throws InterruptedException {
        //clickLogin
        app.clickLoginLink();
        app.fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(app.isAvatarPresentOnHeader());
    }

}