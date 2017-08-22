package no.taardal.mvpdaggerexample.mvppresenter;

import java.util.List;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.mvpmodel.SearchModel;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;

public class SearchMoviesPresenter implements SearchPresenter, MovieListener {

    private MoviesView searchView;
    private SearchModel searchModel;

    @Inject
    public SearchMoviesPresenter(MoviesView moviesView, SearchModel searchModel) {
        this.searchView = moviesView;
        this.searchModel = searchModel;
    }

    @Override
    public void search(String query) {
        searchModel.search(query, this);
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        searchView.setMovies(movies);
    }

    @Override
    public void onFailure() {
        searchView.showErrorMessage();
    }

}
