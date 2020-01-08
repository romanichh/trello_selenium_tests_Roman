package com.roman.trello;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.login();
        }
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoardFromDropDown();
        app.fillBoardForm("qa22" + System.currentTimeMillis());
        app.confirmBoardCreation();
        app.pause(5000);
        app.returnToHomePage();

        int after = app.getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = app.getBoardsCount();
        while (boardsCount > 4) {
            app.deleteBoard();
            boardsCount = app.getBoardsCount();
        }
    }

}