package no.taardal.mvpdaggerexample.mvpmodel;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Arrays;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.mvppresenter.UpcomingMoviesPresenter;

public class UpcomingMoviesModel implements UpcomingModel {

    private MovieApi movieApi;

    @Inject
    public UpcomingMoviesModel(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    @Override
    public void getUpcomingMovies(final UpcomingMoviesPresenter upcomingMoviesPresenter) {
        movieApi.getUpcomingMovies(new Response.Listener<Movie[]>() {

            @Override
            public void onResponse(Movie[] response) {
                upcomingMoviesPresenter.onUpcomingMoviesResult(Arrays.asList(response));
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                upcomingMoviesPresenter.onError();
            }

        });
    }

}
