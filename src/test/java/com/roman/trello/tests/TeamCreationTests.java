package com.roman.trello.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {


    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int countCountbefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm("teamName", "teamDescr");
        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        app.getHeader().returnToHomePage();
        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        app.getTeam().pause(5000);
    }


}
