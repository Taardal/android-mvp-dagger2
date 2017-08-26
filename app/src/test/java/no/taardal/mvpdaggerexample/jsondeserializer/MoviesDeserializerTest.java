package no.taardal.mvpdaggerexample.jsondeserializer;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;

import no.taardal.mvpdaggerexample.movie.Movie;

import static no.taardal.mvpdaggerexample.TestKit.getMovies;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesDeserializerTest {

    private JsonDeserializationContext jsonDeserializationContext;
    private JsonDeserializer<Movie[]> moviesDeserializer;
    private Gson gson;

    @Before
    public void setUp() {
        jsonDeserializationContext = mock(JsonDeserializationContext.class);
        moviesDeserializer = new MoviesDeserializer();
        gson = new Gson();
    }

    @Test(expected = IllegalStateException.class)
    public void givenInvalidJson_ThenShouldThrowException() {
        JsonElement jsonElement = new JsonParser().parse("{\n\"invalid\": [],\n}");
        moviesDeserializer.deserialize(jsonElement, Movie[].class, jsonDeserializationContext);
    }

    @Test
    public void givenTheMovieDatabaseJson_ThenShouldDeserializeJsonIntoMovies() {
        Movie movie = getMovies("Jurassic Park").get(0);

        JsonElement jsonElement = new JsonParser().parse(getTheMovieDatabaseSampleJson());
        when(jsonDeserializationContext.deserialize(any(JsonElement.class), any(Type.class))).thenReturn(movie);

        Movie[] deserializedMovies = moviesDeserializer.deserialize(jsonElement, Movie[].class, jsonDeserializationContext);

        assertEquals(1, deserializedMovies.length);
        assertEquals("Jurassic Park", deserializedMovies[0].getTitle());
        verify(jsonDeserializationContext, times(1)).deserialize(any(JsonElement.class), any(Type.class));
    }

    @Test
    public void givenOpenMovieDatabaseJson_ThenShouldDeserializeJsonIntoMovies() {
        Movie movie = getMovies("The Big Short").get(0);

        JsonElement jsonElement = new JsonParser().parse(getOpenMovieDatabaseSampleJson());
        when(jsonDeserializationContext.deserialize(any(JsonElement.class), any(Type.class))).thenReturn(movie);

        Movie[] deserializedMovies = moviesDeserializer.deserialize(jsonElement, Movie[].class, jsonDeserializationContext);

        assertEquals(1, deserializedMovies.length);
        assertEquals("The Big Short", deserializedMovies[0].getTitle());
        verify(jsonDeserializationContext, times(1)).deserialize(any(JsonElement.class), any(Type.class));
    }

    @NonNull
    private String getTheMovieDatabaseSampleJson() {
        return "{\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"vote_count\": 451,\n" +
                "      \"id\": 396422,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"title\": \"Annabelle: Creation\",\n" +
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
                "    }\n" +
                "  ],\n" +
                "  \"page\": 1,\n" +
                "  \"total_results\": 193,\n" +
                "  \"dates\": {\n" +
                "    \"maximum\": \"2017-09-18\",\n" +
                "    \"minimum\": \"2017-09-01\"\n" +
                "  },\n" +
                "  \"total_pages\": 10\n" +
                "}";
    }

    @NonNull
    private String getOpenMovieDatabaseSampleJson() {
        return "{\n" +
                "  \"Search\": [\n" +
                "    {\n" +
                "      \"Title\": \"Batman Begins\",\n" +
                "      \"Year\": \"2005\",\n" +
                "      \"imdbID\": \"tt0372784\",\n" +
                "      \"Type\": \"movie\",\n" +
                "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"Title\": \"Batman v Superman: Dawn of Justice\",\n" +
                "      \"Year\": \"2016\",\n" +
                "      \"imdbID\": \"tt2975590\",\n" +
                "      \"Type\": \"movie\",\n" +
                "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalResults\": \"332\",\n" +
                "  \"Response\": \"True\"\n" +
                "}";
    }
}
