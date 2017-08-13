package no.taardal.mvpdaggerexample.mvppresenter;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.mvpmodel.TeamModel;
import no.taardal.mvpdaggerexample.mvpview.TeamView;

public class PremierLeagueTeamPresenter implements TeamPresenter {

    private TeamView teamView;
    private TeamModel teamModel;

    @Inject
    public PremierLeagueTeamPresenter(TeamView teamView, TeamModel teamModel) {
        this.teamView = teamView;
        this.teamModel = teamModel;
    }

    @Override
    public void onSetTeam() {
        teamView.setTeam(teamModel.getTeam());
    }

}
