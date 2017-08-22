package no.taardal.mvpdaggerexample.listener;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class MovieResponseErrorListener implements Response.ErrorListener {

    private MovieListener movieListener;

    public MovieResponseErrorListener(MovieListener movieListener) {
        this.movieListener = movieListener;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        movieListener.onFailure();
    }

}
