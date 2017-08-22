package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import no.taardal.mvpdaggerexample.activity.SearchActivity;
import no.taardal.mvpdaggerexample.activity.UpcomingActivity;

@Module
public abstract class AndroidInjectorModule {

    @ContributesAndroidInjector(modules = {
            ViewModule.class,
            PresenterModule.class,
            ModelModule.class,
            ApiModule.class
    })
    abstract UpcomingActivity contributeUpcomingActivityInjector();

    @ContributesAndroidInjector(modules = {
            ViewModule.class,
            PresenterModule.class,
            ModelModule.class,
            ApiModule.class
    })
    abstract SearchActivity contributeSearchActivityInjector();

}
