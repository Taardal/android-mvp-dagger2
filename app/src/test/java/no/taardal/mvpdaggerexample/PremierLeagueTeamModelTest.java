package no.taardal.mvpdaggerexample;

import org.junit.Before;
import org.junit.Test;

import no.taardal.mvpdaggerexample.mvpmodel.PremierLeagueTeamModel;

import static org.junit.Assert.assertEquals;

public class PremierLeagueTeamModelTest {
    
    private PremierLeagueTeamModel premierLeagueTeamModel;

    @Before
    public void setUp() {
        premierLeagueTeamModel = new PremierLeagueTeamModel();
    }

    @Test
    public void getTeam_ReturnsArsenal() {
        assertEquals(premierLeagueTeamModel.getTeam(), "Arsenal");
    }

}
