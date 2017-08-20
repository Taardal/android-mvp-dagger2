package no.taardal.mvpdaggerexample.jsondeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

public class TheMovieDatabaseMovieDeserializer extends Deserializer implements JsonDeserializer<Movie> {

    @Override
    public Movie deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Movie movie = new Movie();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        movie.setTitle(getString(jsonObject.get("title")));
        movie.setImdbId(getString(jsonObject.get("imdbId")));
        movie.setTagline(getString(jsonObject.get("tagline")));
        movie.setOverview(getString(jsonObject.get("overview")));
        movie.setLanguage(getString(jsonObject.get("language")));
        movie.setEdition(getString(jsonObject.get("edition")));
        movie.setRuntime(getInt(jsonObject.get("runtime")));
        movie.setPosterPath(getString(jsonObject.get("posterPath")));
        movie.setBackdropPath(getString(jsonObject.get("backdropPath")));
        return movie;
    }

}
