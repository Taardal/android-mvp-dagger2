package no.taardal.mvpdaggerexample.mvppresenter;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface SearchPresenter {

    void search(String query);

    void onSearchResult(List<Movie> movies);

    void onError();

}
