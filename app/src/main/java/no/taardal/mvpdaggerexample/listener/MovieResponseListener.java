package no.taardal.mvpdaggerexample.listener;

import com.android.volley.Response;

import java.util.Arrays;

import no.taardal.mvpdaggerexample.movie.Movie;

public class MovieResponseListener implements Response.Listener<Movie[]> {

    private MovieListener movieListener;

    public MovieResponseListener(MovieListener movieListener) {
        this.movieListener = movieListener;
    }

    @Override
    public void onResponse(Movie[] movies) {
        movieListener.onSuccess(Arrays.asList(movies));
    }

}
