package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.mvpmodel.SearchModel;
import no.taardal.mvpdaggerexample.mvpmodel.UpcomingModel;
import no.taardal.mvpdaggerexample.mvppresenter.SearchMoviesPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.SearchPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.UpcomingMoviesPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.UpcomingPresenter;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.SearchView;
import no.taardal.mvpdaggerexample.qualifier.UpcomingView;

@Module
public class PresenterModule {

    @Provides
    UpcomingPresenter provideUpcomingMoviesPresenter(@UpcomingView MoviesView moviesView, UpcomingModel upcomingModel) {
        return new UpcomingMoviesPresenter(moviesView, upcomingModel);
    }

    @Provides
    SearchPresenter provideSearchMoviesPresenter(@SearchView MoviesView moviesView, SearchModel searchModel) {
        return new SearchMoviesPresenter(moviesView, searchModel);
    }

}
