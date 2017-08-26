package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.model.SearchModel;
import no.taardal.mvpdaggerexample.model.UpcomingModel;
import no.taardal.mvpdaggerexample.presenter.SearchMoviesPresenter;
import no.taardal.mvpdaggerexample.presenter.SearchPresenter;
import no.taardal.mvpdaggerexample.presenter.UpcomingMoviesPresenter;
import no.taardal.mvpdaggerexample.presenter.UpcomingPresenter;
import no.taardal.mvpdaggerexample.view.MoviesView;
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
