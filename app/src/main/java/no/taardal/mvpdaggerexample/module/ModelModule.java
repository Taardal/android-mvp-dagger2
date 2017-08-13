package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.mvpmodel.PlayerModel;
import no.taardal.mvpdaggerexample.mvpmodel.PremierLeaguePlayerModel;
import no.taardal.mvpdaggerexample.mvpmodel.PremierLeagueTeamModel;
import no.taardal.mvpdaggerexample.mvpmodel.TeamModel;

@Module
public class ModelModule {

    @Provides
    TeamModel providePremierLeagueTeamModel() {
        return new PremierLeagueTeamModel();
    }

    @Provides
    PlayerModel providePremierLeaguePlayerModel() {
        return new PremierLeaguePlayerModel();
    }

}
