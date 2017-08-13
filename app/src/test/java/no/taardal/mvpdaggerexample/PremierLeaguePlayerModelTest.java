package no.taardal.mvpdaggerexample;

import org.junit.Before;
import org.junit.Test;

import no.taardal.mvpdaggerexample.mvpmodel.PremierLeaguePlayerModel;

import static org.junit.Assert.assertEquals;

public class PremierLeaguePlayerModelTest {

    private PremierLeaguePlayerModel premierLeaguePlayerModel;

    @Before
    public void setUp() {
        premierLeaguePlayerModel = new PremierLeaguePlayerModel();
    }

    @Test
    public void getPlayer_ReturnsArsenal() {
        assertEquals(premierLeaguePlayerModel.getPlayer(), "Mesut Øzil");
    }

}
