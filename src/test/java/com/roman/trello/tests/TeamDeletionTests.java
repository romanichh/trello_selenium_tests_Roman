package com.roman.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }


    @Test
    public void deletionBoardTests() throws InterruptedException {
        int countCountbefore = app.getTeam().getTeamsCount();
        app.getTeam().clickOnTheTeam();
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeamButton();
        app.getTeam().submitDeletion();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountbefore - 1);
    }


}
