package no.taardal.mvpdaggerexample.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.model.SearchModel;
import no.taardal.mvpdaggerexample.view.MoviesView;

import static no.taardal.mvpdaggerexample.TestKit.getMovies;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SearchPresenterTest {

    private MoviesView moviesView;
    private SearchModel searchModel;
    private SearchPresenter searchPresenter;

    @Before
    public void setUp() {
        moviesView = mock(MoviesView.class);
        searchModel = mock(SearchModel.class);
        searchPresenter = new SearchMoviesPresenter(moviesView, searchModel);
    }

    @Test
    public void givenQuery_WhenExecutingSearch_ThenModelShouldExecuteSearchWithQuery() {
        String query = "Such query";
        doNothing().when(searchModel).search(anyString(), any(SearchPresenter.class));
        
        searchPresenter.search(query);
        
        verify(searchModel, times(1)).search(query, searchPresenter);
    }

    @Test
    public void givenMovies_WhenReceivingSearchResult_ThenViewShouldSetMovies() {
        List<Movie> movies = getMovies("Iron Man", "Captain America");
        doNothing().when(moviesView).setMovies(ArgumentMatchers.<Movie>anyList());

        searchPresenter.onSearchResult(movies);

        verify(moviesView, times(1)).setMovies(movies);
    }

    @Test
    public void whenError_ThenViewShouldShowErrorMessage() {
        doNothing().when(moviesView).showErrorMessage();
        searchPresenter.onError();
        verify(moviesView, times(1)).showErrorMessage();
    }
    
}
