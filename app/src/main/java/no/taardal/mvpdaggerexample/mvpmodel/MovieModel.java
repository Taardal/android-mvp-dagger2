package no.taardal.mvpdaggerexample.mvpmodel;

import no.taardal.mvpdaggerexample.listener.MovieListener;

public interface MovieModel {

    void getMovies(MovieListener movieListener);

    void search(String query, MovieListener movieListener);

}
