package no.taardal.mvpdaggerexample.api;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.request.MoviesRequest;

public class TheMovieDatabaseApi implements MovieApi {

    private static final String BASE_URL = "http://api.themoviedb.org/3";
    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/original";
    private static final String API_KEY = "b041b0681fa9947874d41095ea1ca5ae";

    private RequestQueue requestQueue;

    @Inject
    public TheMovieDatabaseApi(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void requestUpcomingMovies(Response.Listener<Movie[]> responseListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + "/movie/upcoming?api_key=" + API_KEY;
        requestQueue.add(new MoviesRequest(url, responseListener, errorListener));
    }

    @Override
    public void requestSearch(String query, Response.Listener<Movie[]> responseListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + "/movie/search?api_key=" + API_KEY + "&query=" + query;
        requestQueue.add(new MoviesRequest(url, responseListener, errorListener));
    }

}
