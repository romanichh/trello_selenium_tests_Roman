package com.roman.trello;

import org.openqa.selenium.By;
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

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirmCloseBoard();
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }

    public void startCloseBoard() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickOpenMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }


}
