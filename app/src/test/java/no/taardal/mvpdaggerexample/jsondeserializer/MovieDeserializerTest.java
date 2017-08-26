package no.taardal.mvpdaggerexample.jsondeserializer;

import android.support.annotation.NonNull;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MovieDeserializerTest {

    private JsonDeserializationContext jsonDeserializationContext;
    private JsonDeserializer<Movie> movieDeserializer;

    @Before
    public void setUp() {
        jsonDeserializationContext = mock(JsonDeserializationContext.class);
        movieDeserializer = new MovieDeserializer();
    }

    @Test(expected = JsonSyntaxException.class)
    public void givenInvalidJson_ThenShouldThrowException() {
        JsonElement jsonElement = new JsonParser().parse("{\n\"invalid\": [],\n}");
        movieDeserializer.deserialize(jsonElement, Movie[].class, jsonDeserializationContext);
    }

    @Test
    public void givenTheMovieDatabaseJson_ThenShouldDeserializeJsonIntoMovie() {
        String title = "Mad Max";
        JsonElement jsonElement = new JsonParser().parse(getTheMovieDatabaseResultJson(title));

        Movie movie = movieDeserializer.deserialize(jsonElement, Movie.class, jsonDeserializationContext);

        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        verify(jsonDeserializationContext, times(0)).deserialize(any(JsonElement.class), any(Type.class));
    }

    @Test
    public void givenOpenMovieDatabaseJson_ThenShouldDeserializeJsonIntoMovie() {
        String title = "Mad Max";
        JsonElement jsonElement = new JsonParser().parse(getOpenMovieDatabaseResultJson(title));

        Movie movie = movieDeserializer.deserialize(jsonElement, Movie.class, jsonDeserializationContext);

        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        verify(jsonDeserializationContext, times(0)).deserialize(any(JsonElement.class), any(Type.class));
    }

    @NonNull
    private String getTheMovieDatabaseResultJson(String title) {
        return "{\n" +
                "      \"vote_count\": 451,\n" +
                "      \"id\": 396422,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"title\": \"" + title + "\",\n" +
                "      \"popularity\": 82.549168,\n" +
                "      \"poster_path\": \"/tb86j8jVCVsdZnzf8I6cIi65IeM.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Annabelle: Creation\",\n" +
                "      \"genre_ids\": [\n" +
                "        53,\n" +
                "        27\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/o8u0NyEigCEaZHBdCYTRfXR8U4i.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.\",\n" +
                "      \"release_date\": \"2017-08-09\"\n" +
                "    }";
    }

    @NonNull
    private String getOpenMovieDatabaseResultJson(String title) {
        return "{\n" +
                "      \"Title\": \"" + title + "\",\n" +
                "      \"Year\": \"2005\",\n" +
                "      \"imdbID\": \"tt0372784\",\n" +
                "      \"Type\": \"movie\",\n" +
                "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg\"\n" +
                "    }";
    }


}
