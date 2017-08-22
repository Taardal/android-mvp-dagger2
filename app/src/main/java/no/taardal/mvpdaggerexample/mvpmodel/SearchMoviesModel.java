package no.taardal.mvpdaggerexample.mvpmodel;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.listener.MovieListener;

public class SearchMoviesModel implements SearchModel {

    private MovieApi movieApi;

    @Inject
    public SearchMoviesModel(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    @Override
    public void search(String query, MovieListener movieListener) {
        movieApi.search(query, movieListener);
    }

}
