package no.taardal.mvpdaggerexample.module;

import dagger.Binds;
import dagger.Module;
import no.taardal.mvpdaggerexample.activity.PlayerActivity;
import no.taardal.mvpdaggerexample.activity.TeamActivity;
import no.taardal.mvpdaggerexample.mvpview.PlayerView;
import no.taardal.mvpdaggerexample.mvpview.TeamView;

@Module
public abstract class ViewModule {

    @Binds
    public abstract TeamView provideTeamView(TeamActivity teamActivity);

    @Binds
    public abstract PlayerView providePlayerView(PlayerActivity playerActivity);

}
