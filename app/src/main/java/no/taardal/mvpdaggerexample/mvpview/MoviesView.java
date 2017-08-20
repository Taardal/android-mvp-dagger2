package no.taardal.mvpdaggerexample.mvpview;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface MoviesView {

    void onSetMovies(List<Movie> movies);

}
