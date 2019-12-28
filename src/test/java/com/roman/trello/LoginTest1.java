package com.roman.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest1 extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (isAvatarPresentOnHeader()) {
            logout();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {
        clickLoginLink();
        Assert.assertTrue
                (isAvatarPresentOnHeader());
    }

    @Test
    public void testLogin2() throws InterruptedException {
        clickLoginLink();
        Assert.assertTrue
                (isAvatarPresentOnHeader());
    }

    public void clickLoginLink() throws InterruptedException {
        maximize();
        click(By.cssSelector("[href='/login']"));
        type(By.id("user"), "romich87");
        sleep(5000);

        if (wd.findElement(By.id("password")).isDisplayed()) {
            //fill password
            type(By.id("password"), "romanich1987");
        }
        click(By.id("login"));
        if (isElementPresent(By.id("login-submit"))) {
            click(By.id("login-submit"));

            type(By.id("username"), "romich87@gmail.com");
            click(By.id("login-submit"));
            type(By.id("password"), "romanich1987");
            click(By.id("login-submit"));
            sleep(20000);
        }
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }


    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));

    }
}
