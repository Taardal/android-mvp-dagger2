package no.taardal.mvpdaggerexample.listener;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface MovieListener {

    void onSuccess(List<Movie> movies);

    void onFailure();

}
