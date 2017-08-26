package no.taardal.mvpdaggerexample.api;

import com.android.volley.Response;

import no.taardal.mvpdaggerexample.movie.Movie;

public interface MovieApi {

    void getUpcomingMovies(Response.Listener<Movie[]> movieListener, Response.ErrorListener errorListener);

    void search(String query, Response.Listener<Movie[]> movieListener, Response.ErrorListener errorListener);

}
