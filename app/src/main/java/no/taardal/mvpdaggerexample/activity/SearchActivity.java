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
import no.taardal.mvpdaggerexample.mvppresenter.SearchPresenter;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.SearchView;

@SearchView
public class SearchActivity extends AppCompatActivity implements MoviesView {

    private static final String TAG = SearchActivity.class.getName();

    @Inject
    SearchPresenter searchPresenter;

    @BindView(R.id.recycler_view_search_movies_results)
    RecyclerView searchResultsRecyclerView;

    private String query;
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        query = getQuery();
        moviesAdapter = new MoviesAdapter();
        searchResultsRecyclerView.setAdapter(moviesAdapter);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private String getQuery() {
        String query = getIntent().getExtras().getString(MainActivity.QUERY_EXTRA);
        if (query != null) {
            return query;
        } else {
            return "";
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        searchPresenter.search(query);
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
