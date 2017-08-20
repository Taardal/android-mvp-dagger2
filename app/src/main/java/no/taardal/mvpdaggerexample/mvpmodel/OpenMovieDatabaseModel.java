package no.taardal.mvpdaggerexample.mvpmodel;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.jsondeserializer.OpenMovieDatabaseMovieDeserializer;
import no.taardal.mvpdaggerexample.jsondeserializer.OpenMovieDatabaseMoviesDeserializer;
import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.movie.Movie;

public class OpenMovieDatabaseModel implements MovieModel {

    private static final String TAG = OpenMovieDatabaseModel.class.getName();
    private static final String API_KEY = "b986ada8";
    private static final String API_URL = "http://www.omdbapi.com";
    private static final String IMAGE_URL = "http://img.omdbapi.com";

    private Context context;
    private Gson gson;

    @Inject
    public OpenMovieDatabaseModel(Context context) {
        this.context = context;
        gson = new GsonBuilder()
                .registerTypeAdapter(Movie[].class, new OpenMovieDatabaseMoviesDeserializer())
                .registerTypeAdapter(Movie.class, new OpenMovieDatabaseMovieDeserializer())
                .create();
    }

    @Override
    public void getMovies(final MovieListener movieListener) {

    }

    @Override
    public void search(final String query, final MovieListener movieListener) {
        String url;
        if (!query.isEmpty()) {
            url = API_URL + "?apikey=" + API_KEY + "&s=" + query;
        } else {
            url = API_URL + "?apikey=" + API_KEY + "&s=batman";
        }
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Movie[] movies = gson.fromJson(response, Movie[].class);
                movieListener.onReceivedMovies(Arrays.asList(movies));
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Could not get search for movie by query [" + query + "], [" + error.getMessage() + "]");
            }

        });
        requestQueue.add(stringRequest);
    }

}
