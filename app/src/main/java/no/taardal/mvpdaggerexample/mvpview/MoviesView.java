package no.taardal.mvpdaggerexample.mvpview;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface MoviesView {

    void setMovies(List<Movie> movies);

    void showErrorMessage();
}
