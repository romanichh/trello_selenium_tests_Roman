package com.roman.trello.manager;

import com.roman.trello.model.BoardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(BoardData boardData) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardData.getBoardName());
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void closeBoard() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }

    public void createBoard() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm(new BoardData().setBoardName("qa22" + System.currentTimeMillis()));
        confirmBoardCreation();
        pause(5000);
        returnToHomePage();
    }

    public boolean isThereBoard() {
        return getBoardsCount() > 1;
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

    public void deleteBoard() throws InterruptedException {
        openFirstBoard();
        pause(3000);
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        returnToHomePage();
        pause(10000);
    }

    public void closeAgreeButton() {
        click(By.cssSelector("[value='Close']"));
    }

    public void clickOnThreePoints() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
    }
}
