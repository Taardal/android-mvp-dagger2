package no.taardal.mvpdaggerexample.presenter;

import java.util.List;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.model.SearchModel;
import no.taardal.mvpdaggerexample.view.MoviesView;

public class SearchMoviesPresenter implements SearchPresenter {

    private MoviesView moviesView;
    private SearchModel searchModel;

    @Inject
    public SearchMoviesPresenter(MoviesView moviesView, SearchModel searchModel) {
        this.moviesView = moviesView;
        this.searchModel = searchModel;
    }

    @Override
    public void search(String query) {
        searchModel.search(query, this);
    }

    @Override
    public void onSearchResult(List<Movie> movies) {
        moviesView.setMovies(movies);
    }

    @Override
    public void onError() {
        moviesView.showErrorMessage();
    }

}
