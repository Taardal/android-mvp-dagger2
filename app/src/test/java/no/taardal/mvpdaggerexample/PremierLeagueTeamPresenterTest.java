package no.taardal.mvpdaggerexample;

import org.junit.Before;
import org.junit.Test;

import no.taardal.mvpdaggerexample.mvpmodel.TeamModel;
import no.taardal.mvpdaggerexample.mvppresenter.PremierLeagueTeamPresenter;
import no.taardal.mvpdaggerexample.mvpview.TeamView;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PremierLeagueTeamPresenterTest {

    private TeamView teamViewMock;
    private TeamModel teamModelMock;
    private PremierLeagueTeamPresenter premierLeagueTeamPresenter;

    @Before
    public void setUp() {
        teamViewMock = mock(TeamView.class);
        teamModelMock = mock(TeamModel.class);
        premierLeagueTeamPresenter = new PremierLeagueTeamPresenter(teamViewMock, teamModelMock);
    }

    @Test
    public void onSetTeam_GetsTeamFromModelAndSetsTeamOnView() {
        String team = "Arsenal";
        when(teamModelMock.getTeam()).thenReturn(team);
        doNothing().when(teamViewMock).setTeam(anyString());

        premierLeagueTeamPresenter.onSetTeam();

        verify(teamModelMock, times(1)).getTeam();
        verify(teamViewMock, times(1)).setTeam(team);
    }

}
