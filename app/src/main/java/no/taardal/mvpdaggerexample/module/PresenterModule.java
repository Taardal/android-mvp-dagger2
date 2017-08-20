package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.mvpmodel.MovieModel;
import no.taardal.mvpdaggerexample.mvppresenter.MovieSearchPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.SearchPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.UpcomingMoviesPresenter;
import no.taardal.mvpdaggerexample.mvppresenter.UpcomingPresenter;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.SearchView;
import no.taardal.mvpdaggerexample.qualifier.TMDb;
import no.taardal.mvpdaggerexample.qualifier.UpcomingView;

@Module
public class PresenterModule {

    @Provides
    UpcomingPresenter provideTheMovieDatabaseMoviePresenter(@UpcomingView MoviesView upcomingView, @TMDb MovieModel movieModel) {
        return new UpcomingMoviesPresenter(upcomingView, movieModel);
    }

    @Provides
    SearchPresenter provideOpenMovieDatabaseMoviePresenter(@SearchView MoviesView searchView, @OMDb MovieModel movieModel) {
        return new MovieSearchPresenter(searchView, movieModel);
    }

}
