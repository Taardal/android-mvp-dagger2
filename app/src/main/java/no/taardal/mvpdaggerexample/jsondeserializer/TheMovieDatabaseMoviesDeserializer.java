package no.taardal.mvpdaggerexample.jsondeserializer;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

public class TheMovieDatabaseMoviesDeserializer extends Deserializer implements JsonDeserializer<Movie[]> {

    private static final String TAG = TheMovieDatabaseMoviesDeserializer.class.getName();

    @Override
    public Movie[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonArray jsonArray = jsonElement.getAsJsonObject().get("results").getAsJsonArray();
        Movie[] movies = new Movie[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            movies[i] = jsonDeserializationContext.deserialize(jsonArray.get(i), Movie.class);
        }
        Log.i(TAG, "Deserialized [" + movies.length + "] movies.");
        return movies;
    }

}
