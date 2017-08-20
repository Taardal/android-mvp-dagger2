package no.taardal.mvpdaggerexample;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;

import no.taardal.mvpdaggerexample.activity.MainActivity;

public class MainActivityInstrumentedTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

}
