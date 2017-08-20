package no.taardal.mvpdaggerexample.mvpmodel;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.jsondeserializer.TheMovieDatabaseMovieDeserializer;
import no.taardal.mvpdaggerexample.jsondeserializer.TheMovieDatabaseMoviesDeserializer;
import no.taardal.mvpdaggerexample.movie.Movie;

public class TheMovieDatabaseModel implements MovieModel {

    private static final String TAG = TheMovieDatabaseModel.class.getName();
    private static final String API_KEY = "b041b0681fa9947874d41095ea1ca5ae";
    private static final String API_URL = "http://api.themoviedb.org/3";
    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/original";

    private Context context;
    private Gson gson;

    @Inject
    public TheMovieDatabaseModel(Context context) {
        this.context = context;
        gson = new GsonBuilder()
                .registerTypeAdapter(Movie[].class, new TheMovieDatabaseMoviesDeserializer())
                .registerTypeAdapter(Movie.class, new TheMovieDatabaseMovieDeserializer())
                .create();
    }

    @Override
    public void getMovies(final MovieListener movieListener) {
        String url = API_URL + "/movie/upcoming?api_key=" + API_KEY;
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
                Log.e(TAG, "Could not get upcoming movies [" + error.getMessage() + "]");
            }

        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void search(String query, MovieListener movieListener) {

    }

    public static String getProperty(String key, Context context) {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        try {
            properties.load(assetManager.open("apikey.properties"));
        } catch (IOException e) {
            Log.e(TAG, "Could not load API keys");
        }
        return properties.getProperty(key);
    }

}
