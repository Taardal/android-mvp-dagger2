package no.taardal.mvpdaggerexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.taardal.mvpdaggerexample.R;

public class MainActivity extends AppCompatActivity {

    public static final String QUERY_EXTRA = MainActivity.class.getName() + ".QUERY";

    private static final String TAG = MainActivity.class.getName();

    @BindView(R.id.button_main_upcoming_movies)
    Button upcomingMoviesButton;

    @BindView(R.id.button_main_search)
    Button searchButton;

    @BindView(R.id.edit_text_main_search)
    EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        upcomingMoviesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startUpcomingActivity();
            }

        });
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startSearchActivity();
            }

        });
    }

    private void startUpcomingActivity() {
        startActivity(new Intent(this, UpcomingActivity.class));
    }

    private void startSearchActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra(QUERY_EXTRA, searchEditText.getText().toString());
        startActivity(intent);
    }

}
