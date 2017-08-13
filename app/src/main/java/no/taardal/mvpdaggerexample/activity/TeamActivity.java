package no.taardal.mvpdaggerexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import no.taardal.mvpdaggerexample.R;
import no.taardal.mvpdaggerexample.mvppresenter.TeamPresenter;
import no.taardal.mvpdaggerexample.mvpview.TeamView;

public class TeamActivity extends AppCompatActivity implements TeamView {

    @Inject
    TeamPresenter teamPresenter;

    @BindView(R.id.text_view_team_name)
    TextView teamNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        teamPresenter.onSetTeam();
    }

    @Override
    public void setTeam(String text) {
        teamNameTextView.setText(text);
    }

}
