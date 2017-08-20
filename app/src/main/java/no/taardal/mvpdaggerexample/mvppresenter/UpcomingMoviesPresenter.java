package no.taardal.mvpdaggerexample.mvppresenter;

import java.util.List;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.mvpmodel.MovieModel;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.TMDb;
import no.taardal.mvpdaggerexample.qualifier.UpcomingView;

public class UpcomingMoviesPresenter implements UpcomingPresenter, MovieListener {

    private MoviesView upcomingView;
    private MovieModel movieModel;

    @Inject
    public UpcomingMoviesPresenter(@UpcomingView MoviesView upcomingView, @TMDb MovieModel movieModel) {
        this.upcomingView = upcomingView;
        this.movieModel = movieModel;
    }

    @Override
    public void onViewReady() {
        movieModel.getMovies(this);
    }

    @Override
    public void onReceivedMovies(List<Movie> movies) {
        upcomingView.onSetMovies(movies);
    }

}
