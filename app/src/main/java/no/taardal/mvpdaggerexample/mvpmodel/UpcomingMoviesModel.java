package no.taardal.mvpdaggerexample.mvpmodel;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.listener.MovieListener;

public class UpcomingMoviesModel implements UpcomingModel {

    private MovieApi movieApi;

    @Inject
    public UpcomingMoviesModel(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    @Override
    public void getUpcomingMovies(MovieListener movieListener) {
        movieApi.getUpcomingMovies(movieListener);
    }

}
