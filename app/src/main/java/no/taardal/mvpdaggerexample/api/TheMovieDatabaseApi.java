package no.taardal.mvpdaggerexample.api;

import com.android.volley.RequestQueue;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.request.MovieRequest;

public class TheMovieDatabaseApi implements MovieApi {

    private static final String API_KEY = "b041b0681fa9947874d41095ea1ca5ae";
    private static final String API_URL = "http://api.themoviedb.org/3";
    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/original";

    private RequestQueue requestQueue;

    @Inject
    public TheMovieDatabaseApi(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void getUpcomingMovies(final MovieListener movieListener) {
        String url = API_URL + "/movie/upcoming?api_key=" + API_KEY;
        requestQueue.add(new MovieRequest(url, movieListener));
    }

    @Override
    public void search(String query, MovieListener movieListener) {
        String url = API_URL + "/movie/search?api_key=" + API_KEY + "&query=" + query;
        requestQueue.add(new MovieRequest(url, movieListener));
    }

}
