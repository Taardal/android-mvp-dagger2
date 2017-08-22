package no.taardal.mvpdaggerexample.jsondeserializer;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

public class MoviesDeserializer extends Deserializer implements JsonDeserializer<Movie[]> {

    private static final String TAG = MoviesDeserializer.class.getName();

    @Override
    public Movie[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonArray jsonArray = getJsonArray(jsonElement);
        Movie[] movies = new Movie[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            movies[i] = jsonDeserializationContext.deserialize(jsonArray.get(i), Movie.class);
        }
        Log.i(TAG, "Deserialized [" + movies.length + "] movies.");
        return movies;
    }

    private JsonArray getJsonArray(JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (isOpenMovieDatabaseJsonObject(jsonObject)) {
            return getOpenMovieDatabaseJsonArray(jsonObject);
        } else {
            return getTheMovieDatabaseJsonArray(jsonObject);
        }
    }

    private boolean isOpenMovieDatabaseJsonObject(JsonObject jsonObject) {
        return jsonObject.get("Search") != null;
    }

    private JsonArray getOpenMovieDatabaseJsonArray(JsonObject jsonObject) {
        return jsonObject.get("Search").getAsJsonArray();
    }

    private JsonArray getTheMovieDatabaseJsonArray(JsonObject jsonObject) {
        return jsonObject.get("results").getAsJsonArray();
    }

}
