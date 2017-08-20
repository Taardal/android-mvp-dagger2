package no.taardal.mvpdaggerexample.module;

import dagger.Binds;
import dagger.Module;
import no.taardal.mvpdaggerexample.activity.SearchActivity;
import no.taardal.mvpdaggerexample.activity.UpcomingActivity;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.SearchView;
import no.taardal.mvpdaggerexample.qualifier.UpcomingView;

@Module
public abstract class ViewModule {

    @Binds
    @UpcomingView
    public abstract MoviesView provideUpcomingView(UpcomingActivity upcomingActivity);

    @Binds
    @SearchView
    public abstract MoviesView provideSearchView(SearchActivity searchActivity);

}
