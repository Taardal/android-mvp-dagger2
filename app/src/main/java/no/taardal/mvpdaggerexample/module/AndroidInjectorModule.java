package no.taardal.mvpdaggerexample.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import no.taardal.mvpdaggerexample.activity.SearchActivity;
import no.taardal.mvpdaggerexample.activity.UpcomingActivity;

@Module
public abstract class AndroidInjectorModule {

    @Singleton
    @ContributesAndroidInjector(modules = {
            ViewModule.class,
            PresenterModule.class,
            ModelModule.class,
            ApiModule.class
    })
    abstract UpcomingActivity contributeUpcomingActivityInjector();

    @Singleton
    @ContributesAndroidInjector(modules = {
            ViewModule.class,
            PresenterModule.class,
            ModelModule.class,
            ApiModule.class
    })
    abstract SearchActivity contributeSearchActivityInjector();

}
