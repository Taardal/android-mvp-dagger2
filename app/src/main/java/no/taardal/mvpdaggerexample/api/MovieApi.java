package no.taardal.mvpdaggerexample.api;

import com.android.volley.Response;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface MovieApi {

    void requestUpcomingMovies(Response.Listener<Movie[]> movieListener, Response.ErrorListener errorListener);

    void requestSearch(String query, Response.Listener<Movie[]> movieListener, Response.ErrorListener errorListener);

}
