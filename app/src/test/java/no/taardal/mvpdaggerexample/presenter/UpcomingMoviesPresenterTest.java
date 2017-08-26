package no.taardal.mvpdaggerexample.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.List;

import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.model.UpcomingModel;
import no.taardal.mvpdaggerexample.view.MoviesView;

import static no.taardal.mvpdaggerexample.TestKit.getMovies;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UpcomingMoviesPresenterTest {

    private MoviesView moviesView;
    private UpcomingModel upcomingModel;
    private UpcomingPresenter upcomingPresenter;

    @Before
    public void setUp() {
        moviesView = mock(MoviesView.class);
        upcomingModel = mock(UpcomingModel.class);
        upcomingPresenter = new UpcomingMoviesPresenter(moviesView, upcomingModel);
    }

    @Test
    public void whenViewIsReady_ThenModelShouldGetUpcomingMovies() {
        doNothing().when(upcomingModel).getUpcomingMovies(any(UpcomingPresenter.class));
        upcomingPresenter.onViewReady();
        verify(upcomingModel, times(1)).getUpcomingMovies(upcomingPresenter);
    }

    @Test
    public void givenUpcomingMovies_whenReceivingUpcomingMovies_ThenViewShouldSetMovies() {
        List<Movie> movies = getMovies("Batman", "Superman");
        doNothing().when(moviesView).setMovies(ArgumentMatchers.<Movie>anyList());

        upcomingPresenter.onUpcomingMovies(movies);

        verify(moviesView, times(1)).setMovies(movies);
    }

    @Test
    public void givenError_ThenViewShouldShowErrorMessage() {
        doNothing().when(moviesView).showErrorMessage();
        upcomingPresenter.onError();
        verify(moviesView, times(1)).showErrorMessage();
    }

}
