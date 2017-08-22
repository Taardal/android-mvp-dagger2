package no.taardal.mvpdaggerexample.request;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

import no.taardal.mvpdaggerexample.jsondeserializer.MovieDeserializer;
import no.taardal.mvpdaggerexample.jsondeserializer.MoviesDeserializer;
import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.listener.MovieResponseErrorListener;
import no.taardal.mvpdaggerexample.listener.MovieResponseListener;
import no.taardal.mvpdaggerexample.movie.Movie;

public class MovieRequest extends Request<Movie[]> {

    private static final String TAG = MovieRequest.class.getName();

    private Gson gson;
    private Response.Listener<Movie[]> responseListener;

    public MovieRequest(String url, MovieListener movieListener) {
        super(Method.GET, url, new MovieResponseErrorListener(movieListener));
        this.responseListener = new MovieResponseListener(movieListener);
        gson = new GsonBuilder()
                .registerTypeAdapter(Movie[].class, new MoviesDeserializer())
                .registerTypeAdapter(Movie.class, new MovieDeserializer())
                .create();
    }

    @Override
    protected void deliverResponse(Movie[] response) {
        responseListener.onResponse(response);
    }

    @Override
    protected Response<Movie[]> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String json = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(gson.fromJson(json, Movie[].class), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Could not parse response encoding.", e);
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Could not parse JSON syntax.", e);
            return Response.error(new ParseError(e));
        }
    }
}
