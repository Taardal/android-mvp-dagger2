package no.taardal.mvpdaggerexample.presenter;

import java.util.List;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.model.UpcomingModel;
import no.taardal.mvpdaggerexample.view.MoviesView;

public class UpcomingMoviesPresenter implements UpcomingPresenter {

    private MoviesView moviesView;
    private UpcomingModel upcomingModel;

    @Inject
    public UpcomingMoviesPresenter(MoviesView moviesView, UpcomingModel upcomingModel) {
        this.moviesView = moviesView;
        this.upcomingModel = upcomingModel;
    }

    @Override
    public void onViewReady() {
        upcomingModel.getUpcomingMovies(this);
    }

    @Override
    public void onUpcomingMovies(List<Movie> movies) {
        moviesView.setMovies(movies);
    }

    @Override
    public void onError() {
        moviesView.showErrorMessage();
    }

}
