package no.taardal.mvpdaggerexample.jsondeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

public class OpenMovieDatabaseMovieDeserializer extends Deserializer implements JsonDeserializer<Movie> {

    @Override
    public Movie deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Movie movie = new Movie();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        movie.setTitle(getString(jsonObject.get("Title")));
        movie.setImdbId(getString(jsonObject.get("imdbID")));
        return movie;
    }

}
