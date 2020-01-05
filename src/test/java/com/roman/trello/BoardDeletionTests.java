package com.roman.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            login();
        }
        if (!isThereBoard()) {
            createBoard();
        }
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        openFirstBoard();
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        permanentlyDeleteBoard();
        returnToHomePage();
        pause(10000);
    }

    @Test
    public void testFirstBoardDeletion2() throws InterruptedException {
        openFirstBoard();
        pause(3000);
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        returnToHomePage();
        pause(10000);
    }


}
