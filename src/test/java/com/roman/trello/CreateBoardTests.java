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
        int before = app.getBoardHelper().getBoardsCount();
        app.clickOnPlusButton();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardForm("qa22" + System.currentTimeMillis());
        app.getBoardHelper().confirmBoardCreation();
        app.pause(5000);
        app.returnToHomePage();

        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = app.getBoardHelper().getBoardsCount();
        while (boardsCount > 4) {
            app.getBoardHelper().deleteBoard();
            boardsCount = app.getBoardHelper().getBoardsCount();
        }
    }

}