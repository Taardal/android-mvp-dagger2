package no.taardal.mvpdaggerexample.jsondeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

public class MovieDeserializer extends Deserializer implements JsonDeserializer<Movie> {

    @Override
    public Movie deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (isOpenMovieDatabaseJsonObject(jsonObject)) {
            return getOpenMovieDatabaseMovie(jsonObject);
        } else {
            return getTheMovieDatabaseMovie(jsonObject);
        }
    }

    private boolean isOpenMovieDatabaseJsonObject(JsonObject jsonObject) {
        return jsonObject.get("Title") != null;
    }

    private Movie getOpenMovieDatabaseMovie(JsonObject jsonObject) {
        Movie movie = new Movie();
        movie.setTitle(getString(jsonObject.get("Title")));
        movie.setImdbId(getString(jsonObject.get("imdbID")));
        return movie;
    }

    private Movie getTheMovieDatabaseMovie(JsonObject jsonObject) {
        Movie movie = new Movie();
        movie.setTitle(getString(jsonObject.get("title")));
        movie.setImdbId(getString(jsonObject.get("imdbId")));
        movie.setTagline(getString(jsonObject.get("tagline")));
        movie.setOverview(getString(jsonObject.get("overview")));
        movie.setLanguage(getString(jsonObject.get("original_language")));
        movie.setReleaseDate(getString(jsonObject.get("release_date")));
        movie.setRuntime(getInt(jsonObject.get("runtime")));
        return movie;
    }

}
