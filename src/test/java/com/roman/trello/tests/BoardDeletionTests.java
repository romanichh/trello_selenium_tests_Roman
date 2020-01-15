package com.roman.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
        if (!app.getBoard().isThereBoard()) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        app.getBoard().openFirstBoard();
        app.getBoard().clickOpenMore();
        app.getBoard().startCloseBoard();
        app.getBoard().confirmCloseBoard();
        app.getBoard().permanentlyDeleteBoard();
        app.getSession().returnToHomePage();
        app.getSession().pause(10000);
    }

    @Test
    public void testFirstBoardDeletion2() throws InterruptedException {
        app.getBoard().openFirstBoard();
        app.getSession().pause(3000);
        app.getBoard().clickOpenMore();
        app.getBoard().startCloseBoard();
        app.getBoard().confirmCloseBoard();
        app.getSession().returnToHomePage();
        app.getSession().pause(10000);
    }


}
