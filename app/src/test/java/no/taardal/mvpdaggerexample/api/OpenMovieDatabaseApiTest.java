package no.taardal.mvpdaggerexample.api;

import com.android.volley.RequestQueue;

import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import no.taardal.mvpdaggerexample.request.MoviesRequest;

import static no.taardal.mvpdaggerexample.TestKit.getErrorListener;
import static no.taardal.mvpdaggerexample.TestKit.getListener;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OpenMovieDatabaseApiTest {

    private RequestQueue requestQueue;
    private MovieApi movieApi;

    @Before
    public void setUp() {
        requestQueue = mock(RequestQueue.class);
        movieApi = new TheMovieDatabaseApi(requestQueue);
    }

    @Test
    public void whenRequestingUpcomingMovies_ThenShouldExecuteMovieRequest() throws UnsupportedEncodingException {
        doNothing().when(requestQueue).add(any(MoviesRequest.class));
        movieApi.requestUpcomingMovies(getListener(), getErrorListener());
        verify(requestQueue.add(any(MoviesRequest.class)), times(1));
    }

    @Test
    public void givenQuery_WhenRequestingSearch_ThenShouldExecuteMovieRequest() {
        String query = "Many query";
        doNothing().when(requestQueue).add(any(MoviesRequest.class));
        movieApi.requestSearch(query, getListener(), getErrorListener());
        verify(requestQueue.add(any(MoviesRequest.class)), times(1));
    }

}
