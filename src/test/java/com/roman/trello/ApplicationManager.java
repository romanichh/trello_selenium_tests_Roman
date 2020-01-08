package com.roman.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void init() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }

//        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public void stop() {
        wd.quit();
    }

    protected void maximize() {
        wd.manage().window().maximize();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void fillLoginForm(String user, String pwd) throws InterruptedException {
        //username
        type(By.id("user"), user);
        pause(3000);
        click(By.id("login"));
        //email
        type(By.id("username"), "romich87@gmail.com");
        click(By.id("login-submit"));
        //password
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
        pause(20000);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void clickLoginLink() throws InterruptedException {
        maximize();
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void login() throws InterruptedException {
        clickLoginLink();
        fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(isAvatarPresentOnHeader());
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        click(By.name("house"));
        pause(10000);
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));

    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void closeAgreeButton() {
        click(By.cssSelector("[value='Close']"));
    }

    public void closeBoard() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnThreePoints() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
    }

    public void clickOnBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }

    public void createBoard() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("qa22" + System.currentTimeMillis());
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
}
