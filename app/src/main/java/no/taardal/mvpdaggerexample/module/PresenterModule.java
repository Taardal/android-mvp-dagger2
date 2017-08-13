package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.mvpmodel.PlayerModel;
import no.taardal.mvpdaggerexample.mvpmodel.TeamModel;
import no.taardal.mvpdaggerexample.mvppresenter.PlayerPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.PremierLeaguePlayerPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.PremierLeagueTeamPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.TeamPresenter;
import no.taardal.mvpdaggerexample.mvpview.PlayerView;
import no.taardal.mvpdaggerexample.mvpview.TeamView;

@Module
public class PresenterModule {

    @Provides
    TeamPresenter provideTeamPresenter(TeamView teamView, TeamModel teamModel) {
        return new PremierLeagueTeamPresenter(teamView, teamModel);
    }

    @Provides
    PlayerPresenter providePlayerPresenter(PlayerView playerView, PlayerModel playerModel) {
        return new PremierLeaguePlayerPresenter(playerView, playerModel);
    }

}
