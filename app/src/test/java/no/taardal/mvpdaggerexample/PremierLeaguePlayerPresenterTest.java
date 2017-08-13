package no.taardal.mvpdaggerexample;

import org.junit.Before;
import org.junit.Test;

import no.taardal.mvpdaggerexample.mvpmodel.PlayerModel;
import no.taardal.mvpdaggerexample.mvppresenter.PremierLeaguePlayerPresenter;
import no.taardal.mvpdaggerexample.mvpview.PlayerView;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PremierLeaguePlayerPresenterTest {

    private PlayerView playerViewMock;
    private PlayerModel playerModelMock;
    private PremierLeaguePlayerPresenter premierLeaguePlayerPresenter;

    @Before
    public void setUp() {
        playerViewMock = mock(PlayerView.class);
        playerModelMock = mock(PlayerModel.class);
        premierLeaguePlayerPresenter = new PremierLeaguePlayerPresenter(playerViewMock, playerModelMock);
    }

    @Test
    public void onSetPlayer_GetsPlayerFromModelAndSetsPlayerOnView() {
        String player = "Alexandre Lacazette";
        when(playerModelMock.getPlayer()).thenReturn(player);
        doNothing().when(playerViewMock).setPlayer(anyString());

        premierLeaguePlayerPresenter.onSetPlayer();

        verify(playerModelMock, times(1)).getPlayer();
        verify(playerViewMock, times(1)).setPlayer(player);
    }

}
