package no.taardal.mvpdaggerexample.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Arrays;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.presenter.SearchPresenter;

public class SearchMoviesModel implements SearchModel {

    private MovieApi movieApi;

    @Inject
    public SearchMoviesModel(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    @Override
    public void search(String query, final SearchPresenter searchPresenter) {
        movieApi.requestSearch(query, new Response.Listener<Movie[]>() {

            @Override
            public void onResponse(Movie[] response) {
                searchPresenter.onSearchResult(Arrays.asList(response));
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                searchPresenter.onError();
            }

        });
    }

}
