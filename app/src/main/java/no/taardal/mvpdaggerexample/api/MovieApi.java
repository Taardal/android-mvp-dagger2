package no.taardal.mvpdaggerexample.api;

import no.taardal.mvpdaggerexample.listener.MovieListener;

public interface MovieApi {

    void getUpcomingMovies(MovieListener movieListener);
    void search(String query, MovieListener movieListener);

}
