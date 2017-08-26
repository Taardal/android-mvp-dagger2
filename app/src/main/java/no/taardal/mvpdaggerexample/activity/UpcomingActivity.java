package no.taardal.mvpdaggerexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import no.taardal.mvpdaggerexample.R;
import no.taardal.mvpdaggerexample.adapter.MoviesAdapter;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.presenter.UpcomingPresenter;
import no.taardal.mvpdaggerexample.view.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.UpcomingView;

@UpcomingView
public class UpcomingActivity extends AppCompatActivity implements MoviesView {

    @Inject
    UpcomingPresenter upcomingPresenter;

    @BindView(R.id.recycler_view_upcoming_movies)
    RecyclerView upcomingMoviesRecyclerView;

    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ButterKnife.bind(this);
        moviesAdapter = new MoviesAdapter();
        upcomingMoviesRecyclerView.setAdapter(moviesAdapter);
        upcomingMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        upcomingPresenter.onViewReady();
    }

    @Override
    public void setMovies(List<Movie> movies) {
        moviesAdapter.setMovies(movies);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_SHORT).show();
    }

}
