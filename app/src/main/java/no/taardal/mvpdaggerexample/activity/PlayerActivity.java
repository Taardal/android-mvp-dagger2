package no.taardal.mvpdaggerexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import no.taardal.mvpdaggerexample.R;
import no.taardal.mvpdaggerexample.mvppresenter.PlayerPresenter;
import no.taardal.mvpdaggerexample.mvpview.PlayerView;

public class PlayerActivity extends AppCompatActivity implements PlayerView {

    @Inject
    PlayerPresenter playerPresenter;

    @BindView(R.id.text_view_player_name)
    TextView playerNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        playerPresenter.onSetPlayer();
    }

    @Override
    public void setPlayer(String team) {
        playerNameTextView.setText(team);
    }

}
