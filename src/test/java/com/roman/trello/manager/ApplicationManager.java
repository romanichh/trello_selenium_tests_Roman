package com.roman.trello.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    BoardHelper board;
    SessionHelper session;
    HeaderHelper header;
    TeamHelper team;

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
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        maximize();
        wd.get("https://trello.com/");

        board = new BoardHelper(wd);
        session = new SessionHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
    }


    public void stop() {
        wd.quit();
    }

    protected void maximize() {
        wd.manage().window().maximize();
    }

    public BoardHelper getBoard() {
        return board;
    }

    public SessionHelper getSession() {
        return session;
    }

    public HeaderHelper getHeader() {
        return header;
    }
    public TeamHelper getTeam() {
        return team;
    }

}
