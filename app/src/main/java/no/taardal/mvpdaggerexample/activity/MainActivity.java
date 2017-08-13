package no.taardal.mvpdaggerexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.taardal.mvpdaggerexample.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_main_team)
    Button teamButton;

    @BindView(R.id.button_main_player)
    Button playerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        teamButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(TeamActivity.class);
            }

        });
        playerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(PlayerActivity.class);
            }

        });
    }

    private void startActivity(Class<? extends AppCompatActivity> activity) {
        startActivity(new Intent(this, activity));
    }

}
