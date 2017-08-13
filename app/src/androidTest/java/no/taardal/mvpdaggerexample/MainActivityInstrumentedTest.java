package no.taardal.mvpdaggerexample;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import no.taardal.mvpdaggerexample.activity.MainActivity;
import no.taardal.mvpdaggerexample.activity.PlayerActivity;
import no.taardal.mvpdaggerexample.activity.TeamActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentedTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void shouldTeamButtonAndPlayerButton() {
        onView(withId(R.id.button_main_team)).check(matches(withText(R.string.team)));
        onView(withId(R.id.button_main_player)).check(matches(withText(R.string.player)));
    }

    @Test
    public void teamButtonClick_ShouldStartTeamActivity() {
        onView(withId(R.id.button_main_team)).perform(click());
        intended(hasComponent(TeamActivity.class.getName()));
        onView(withId(R.id.text_view_team_name)).check(matches(withText("Arsenal")));
    }

    @Test
    public void playerButtonClick_ShouldStartPlayerActivity() {
        onView(withId(R.id.button_main_player)).perform(click());
        intended(hasComponent(PlayerActivity.class.getName()));
        onView(withId(R.id.text_view_player_name)).check(matches(withText("Mesut Øzil")));
    }

}
