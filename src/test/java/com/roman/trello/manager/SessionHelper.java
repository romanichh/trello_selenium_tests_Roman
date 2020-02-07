package com.roman.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginForm(String user, String pwd) throws InterruptedException {
        //username
        type(By.id("user"), user);
        pause(5000);
        click(By.id("login"));
        //email
        type(By.id("username"), "romich87@gmail.com");
        pause(3000);
        click(By.id("login-submit"));
        pause(5000);
        //password
        type(By.cssSelector("input[id=password]"), pwd);
//        type(By.id("password"), pwd);
        click(By.id("login-submit"));
        pause(10000);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void clickLoginLink() throws InterruptedException {

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

    public void logout() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        pause(10000);
    }

    public void openUserProfileFromDropDown() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianAccount() {
        click(By.cssSelector("[href $=manage-profile]"));
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
    }

    public void addPictureAndCloseWindow() throws InterruptedException {
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).perform();
        click(By.cssSelector("[data-test-selector='profile-hover-info']"));
        if (isElementPresent(By.cssSelector("[role=menu]"))) {
            click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
        }
        attach(By.id("image-input"), new File("C:/Users/romic/Documents/GitHub/trello_selenium_tests_Roman/src/test/resources/foto (13).jpg"));
        click(By.xpath("//*[contains(text(),'Upload')]"));
        pause(5000);
        wd.close();
        pause(3000);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }

    }


    public void deletePictureAndCloseWindow() throws InterruptedException {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"));
        new Actions(wd).moveToElement(avatar).perform();
        click(By.cssSelector("[data-test-selector='profile-hover-info']"));
        if (isElementPresent(By.xpath("//*[contains(text(),'Remove')]"))) {
            click(By.xpath("//*[contains(text(),'Remove')]"));
        }
        pause(3000);
        wd.close();
        pause(3000);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }
    }

    public void addHeaderImageAndCloseWindow() throws InterruptedException {

        WebElement avatar = wd.findElement(By.cssSelector(".krdvGz"));
        new Actions(wd).moveToElement(avatar).perform();

        click(By.cssSelector(".krdvGz"));
        pause(5000);
        if (isElementPresent(By.xpath("//*[@class='Item-z6qfkt-2 fawwoK'][1]"))) {
            attach(By.xpath("//*[@class='Item-z6qfkt-2 fawwoK'][1]"), new File("C:/Users/romic/Documents/GitHub/trello_selenium_tests_Roman/src/test/resources/foto (13).jpg"));
        }
        pause(7000);
        wd.close();
        pause(3000);

    }

    public void goToPreviousWindow() throws InterruptedException {

        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }
    }
}
