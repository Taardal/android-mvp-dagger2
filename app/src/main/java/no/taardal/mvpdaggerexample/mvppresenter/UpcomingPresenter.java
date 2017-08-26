package no.taardal.mvpdaggerexample.mvppresenter;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface UpcomingPresenter {

    void onViewReady();

    void onUpcomingMoviesResult(List<Movie> movies);

    void onError();

}
