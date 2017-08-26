package no.taardal.mvpdaggerexample.model;

import com.android.volley.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.List;

import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.presenter.UpcomingPresenter;

import static no.taardal.mvpdaggerexample.TestKit.getMovies;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UpcomingMoviesModelTest {

    private MovieApi movieApi;
    private UpcomingPresenter upcomingPresenter;
    private UpcomingModel upcomingModel;

    @Before
    public void setUp() {
        movieApi = mock(MovieApi.class);
        upcomingPresenter = mock(UpcomingPresenter.class);
        upcomingModel = new UpcomingMoviesModel(movieApi);
    }

    @Test
    public void givenUpcomingPresenter_WhenGettingUpcomingMovies_ThenMovieApiShouldRequestUpcomingMovies() {
        List<Movie> movies = getMovies("John Wick", "John Wick: Chapter 2");
        doNothing().when(upcomingPresenter).onUpcomingMovies(ArgumentMatchers.<Movie>anyList());
        doNothing().when(movieApi).requestUpcomingMovies(ArgumentMatchers.<Response.Listener<Movie[]>>any(), any(Response.ErrorListener.class));

        upcomingModel.getUpcomingMovies(upcomingPresenter);

        verify(movieApi, times(1)).requestUpcomingMovies(ArgumentMatchers.<Response.Listener<Movie[]>>any(), any(Response.ErrorListener.class));
        verify(upcomingPresenter, times(0)).onUpcomingMovies(movies);
    }

}
