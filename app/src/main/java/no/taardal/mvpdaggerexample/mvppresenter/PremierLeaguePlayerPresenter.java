package no.taardal.mvpdaggerexample.mvppresenter;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.mvpmodel.PlayerModel;
import no.taardal.mvpdaggerexample.mvpview.PlayerView;

public class PremierLeaguePlayerPresenter implements PlayerPresenter {

    private PlayerView playerView;
    private PlayerModel playerModel;

    @Inject
    public PremierLeaguePlayerPresenter(PlayerView playerView, PlayerModel playerModel) {
        this.playerView = playerView;
        this.playerModel = playerModel;
    }

    @Override
    public void onSetPlayer() {
        playerView.setPlayer(playerModel.getPlayer());
    }

}
