package com.roman.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.login();
        }
        if (!app.isThereBoard()) {
            app.createBoard();
        }
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        app.openFirstBoard();
        app.clickOpenMore();
        app.startCloseBoard();
        app.confirmCloseBoard();
        app.permanentlyDeleteBoard();
        app.returnToHomePage();
        app.pause(10000);
    }

    @Test
    public void testFirstBoardDeletion2() throws InterruptedException {
        app.openFirstBoard();
        app.pause(3000);
        app.clickOpenMore();
        app.startCloseBoard();
        app.confirmCloseBoard();
        app.returnToHomePage();
        app.pause(10000);
    }


}
