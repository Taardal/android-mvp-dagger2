package no.taardal.mvpdaggerexample.api;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.request.MoviesRequest;

public class OpenMovieDatabaseApi implements MovieApi {

    private static final String BASE_URL = "http://www.omdbapi.com";
    private static final String IMAGE_URL = "http://img.omdbapi.com";
    private static final String API_KEY = "b986ada8";

    private RequestQueue requestQueue;

    @Inject
    public OpenMovieDatabaseApi(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void getUpcomingMovies(Response.Listener<Movie[]> responseListener, Response.ErrorListener errorListener) {

    }

    @Override
    public void search(String query, Response.Listener<Movie[]> responseListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + "?apikey=" + API_KEY + "&s=" + query;
        requestQueue.add(new MoviesRequest(url, responseListener, errorListener));
    }

}
