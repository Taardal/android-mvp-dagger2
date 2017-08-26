package no.taardal.mvpdaggerexample.model;

import com.android.volley.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.List;

import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.presenter.SearchPresenter;

import static no.taardal.mvpdaggerexample.TestKit.getMovies;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SearchMoviesModelTest {

    private MovieApi movieApi;
    private SearchPresenter searchPresenter;
    private SearchModel searchModel;

    @Before
    public void setUp() {
        movieApi = mock(MovieApi.class);
        searchPresenter = mock(SearchPresenter.class);
        searchModel = new SearchMoviesModel(movieApi);
    }

    @Test
    public void givenSearchPresenter_WhenGettingSearchMovies_ThenMovieApiShouldRequestSearchMovies() {
        String query = "Very query";
        List<Movie> movies = getMovies("John Wick", "John Wick: Chapter 2");
        doNothing().when(searchPresenter).onSearchResult(ArgumentMatchers.<Movie>anyList());
        doNothing().when(movieApi).requestSearch(anyString(), ArgumentMatchers.<Response.Listener<Movie[]>>any(), any(Response.ErrorListener.class));

        searchModel.search(query, searchPresenter);

        verify(movieApi, times(1)).requestSearch(query, ArgumentMatchers.<Response.Listener<Movie[]>>any(), any(Response.ErrorListener.class));
        verify(searchPresenter, times(0)).onSearchResult(movies);
    }

}
