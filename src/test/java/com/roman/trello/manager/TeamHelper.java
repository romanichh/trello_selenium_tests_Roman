package com.roman.trello.manager;

import com.roman.trello.model.TeamData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void clickLaterButton() {
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void closeInviteToTheTeamForm() {
        click(By.cssSelector("[name='close']"));
    }

    public void fillTeamCreationForm(TeamData teamData) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamData.getTeamName());
        type(By.cssSelector("[id$=description]"), teamData.getTeamDescr());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnDeleteTeamButton() {
        click(By.xpath("//*[@class='quiet-button']"));
    }

    public void submitDeletion() {
        click(By.cssSelector("[value='Delete Forever']"));
    }

    public void clickOnTeamSettings() {
        click(By.cssSelector("[class^=icon-gear]"));
    }

    public void clickOnTheTeam() {
        click(By.cssSelector("[data-test-id^=home-team-tab-section]"));
    }

    public void changeTeamName() {
        click(By.cssSelector("[name='displayName']"));
        wd.findElement(By.cssSelector("[name='displayName']")).clear();
        wd.findElement(By.cssSelector("[name='displayName']")).sendKeys("Test");
        //click on save button
        click(By.cssSelector(".primary.wide.js-submit-profile"));
    }

    public void clickOnEditTeamProfileButton() {
        click(By.cssSelector(".js-edit-profile"));
    }


    private String getText(By Text) {
        return wd.findElement(Text).getText();
    }
}