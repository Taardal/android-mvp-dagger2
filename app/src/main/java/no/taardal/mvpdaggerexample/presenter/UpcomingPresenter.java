package no.taardal.mvpdaggerexample.presenter;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface UpcomingPresenter {

    void onViewReady();

    void onUpcomingMovies(List<Movie> movies);

    void onError();

}
