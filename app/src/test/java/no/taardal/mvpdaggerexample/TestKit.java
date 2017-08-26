package no.taardal.mvpdaggerexample;

import android.support.annotation.NonNull;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;

public class TestKit {

    private TestKit() {
    }

    public static List<Movie> getMovies(String... titles) {
        List<Movie> movies = new ArrayList<>();
        for (String title : titles) {
            Movie movie = new Movie();
            movie.setTitle(title);
            movies.add(movie);
        }
        return movies;
    }

    @NonNull
    public static Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        };
    }

    @NonNull
    public static Response.Listener<Movie[]> getListener() {
        return new Response.Listener<Movie[]>() {

            @Override
            public void onResponse(Movie[] response) {

            }

        };
    }

}
