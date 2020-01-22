package com.roman.trello.tests;

import com.roman.trello.model.TeamData;
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

    @Test(dataProvider = "validTeamsCSV", dataProviderClass = DataProviders.class)
    public void teamCreationTestFromHeaderfromCSV(TeamData team) throws InterruptedException {
        int countCountbefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(team);
        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        app.getHeader().returnToHomePage();
//        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        app.getTeam().pause(5000);
    }

    @Test(dataProvider = "validTeams", dataProviderClass = DataProviders.class)
    public void teamCreationTestFromHeaderWithDP(String teamName, String teamDescr) throws InterruptedException {
        int countCountbefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData().withTeamName(teamName).withTeamDescr(teamDescr));
        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        app.getHeader().returnToHomePage();
//        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        app.getTeam().pause(5000);
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int countCountbefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData().withTeamName("teamName").withTeamDescr("teamDescr"));
        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        app.getHeader().returnToHomePage();
        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        app.getTeam().pause(5000);
    }

    @Test
    public void teamCreationTestFromHeaderWithNameOnly() throws InterruptedException {
        int countCountbefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData().withTeamName("teamName"));
        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        app.getHeader().returnToHomePage();
        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        app.getTeam().pause(5000);
    }
}
