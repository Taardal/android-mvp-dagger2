package no.taardal.mvpdaggerexample.mvpmodel;

import no.taardal.mvpdaggerexample.listener.MovieListener;

public interface UpcomingModel {

    void getUpcomingMovies(MovieListener movieListener);

}
