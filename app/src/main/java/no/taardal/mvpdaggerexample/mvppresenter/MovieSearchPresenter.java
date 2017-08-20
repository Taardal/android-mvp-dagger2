package no.taardal.mvpdaggerexample.mvppresenter;

import java.util.List;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.mvpmodel.MovieModel;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.SearchView;

public class MovieSearchPresenter implements SearchPresenter, MovieListener {

    private MoviesView searchView;
    private MovieModel movieModel;

    @Inject
    public MovieSearchPresenter(@SearchView MoviesView searchView, @OMDb MovieModel movieModel) {
        this.searchView = searchView;
        this.movieModel = movieModel;
    }

    @Override
    public void search(String query) {
        movieModel.search(query, this);
    }

    @Override
    public void onReceivedMovies(List<Movie> movies) {
        searchView.onSetMovies(movies);
    }

}
