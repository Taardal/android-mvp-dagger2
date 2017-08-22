package no.taardal.mvpdaggerexample.api;

import android.util.Log;

import com.android.volley.RequestQueue;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.mvpmodel.SearchMoviesModel;
import no.taardal.mvpdaggerexample.request.MovieRequest;

public class OpenMovieDatabaseApi implements MovieApi {

    private static final String TAG = SearchMoviesModel.class.getName();
    private static final String API_KEY = "b986ada8";
    private static final String API_URL = "http://www.omdbapi.com";
    private static final String IMAGE_URL = "http://img.omdbapi.com";

    private RequestQueue requestQueue;

    @Inject
    public OpenMovieDatabaseApi(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void getUpcomingMovies(MovieListener movieListener) {
        movieListener.onFailure();
    }

    @Override
    public void search(String query, MovieListener movieListener) {
        String url = API_URL + "?apikey=" + API_KEY + "&s=" + query;
        Log.i(TAG, url);
        requestQueue.add(new MovieRequest(url, movieListener));
    }

}
