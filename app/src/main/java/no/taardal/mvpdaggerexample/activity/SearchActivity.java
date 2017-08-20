package no.taardal.mvpdaggerexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import no.taardal.mvpdaggerexample.R;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.mvppresenter.SearchPresenter;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;
import no.taardal.mvpdaggerexample.qualifier.SearchView;

@SearchView
public class SearchActivity extends AppCompatActivity implements MoviesView {

    private static final String TAG = SearchActivity.class.getName();

    private String query = "";

    @Inject
    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        query = getIntent().getExtras().getString(MainActivity.QUERY_EXTRA);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        searchPresenter.search(query);
    }

    @Override
    public void onSetMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            Log.i(TAG, movie.toString());
        }
        Toast.makeText(getApplicationContext(), "Got [" + movies.size() + "] movies.", Toast.LENGTH_LONG).show();
    }

}
