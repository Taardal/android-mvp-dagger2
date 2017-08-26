package no.taardal.mvpdaggerexample;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import no.taardal.mvpdaggerexample.activity.MainActivity;
import no.taardal.mvpdaggerexample.activity.SearchActivity;
import no.taardal.mvpdaggerexample.activity.UpcomingActivity;

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
    public void whenCreated_ThenButtonsShouldHaveCorrectText() {
        onView(withId(R.id.button_main_search)).check(matches(withText(R.string.main_search_for_movies_by_title)));
        onView(withId(R.id.button_main_upcoming_movies)).check(matches(withText(R.string.main_check_out_upcoming_movies)));
    }

    @Test
    public void whenUpcomingButtonClicked_ThenUpcomingActivityShouldBeLaunched() {
        onView(withId(R.id.button_main_upcoming_movies)).perform(click());
        intended(hasComponent(UpcomingActivity.class.getName()));
    }

    @Test
    public void whenSearchButtonClicked_ThenSearchActivityShouldBeLaunched() {
        onView(withId(R.id.button_main_search)).perform(click());
        intended(hasComponent(SearchActivity.class.getName()));
    }

}
